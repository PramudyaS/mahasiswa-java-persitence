package controller;

import entity.Mahasiswa;
import helper.PersistenceHelper;
import jakarta.persistence.EntityManager;
import view.FormMahasiswa;

import java.io.Serializable;
import java.util.List;

public class MahasiswaController implements Serializable {

    private FormMahasiswa view;

    public MahasiswaController(FormMahasiswa view) {
        this.view = view;
    }

    public void create()  {
        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
        manager.getTransaction().begin();
        try {
            Mahasiswa tbMahasiswa = new Mahasiswa();
            tbMahasiswa.setNrp(view.getFieldNRP().getText());
            tbMahasiswa.setNama(view.getFieldNama().getText());
            tbMahasiswa.setAngkatan(view.getFieldAngkatan().getText());
            tbMahasiswa.setSma(view.getFieldSMA().getText());

            view.getFieldNRP().setText("");
            view.getFieldNama().setText("");
            view.getFieldAngkatan().setText("");
            view.getFieldSMA().setText("");

            manager.persist(tbMahasiswa);
            view.getTableModelMahasiswa().insert(tbMahasiswa);

            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void update() {
        int index = view.getTableMahasiswa().getSelectedRow();
        if (index == -1) {
            return;
        }

        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
        manager.getTransaction().begin();
        try {
            Mahasiswa tbMahasiswa = view.getTableModelMahasiswa().select(index);
            tbMahasiswa.setNrp(view.getFieldNRP().getText());
            tbMahasiswa.setNama(view.getFieldNama().getText());
            tbMahasiswa.setAngkatan(view.getFieldAngkatan().getText());
            tbMahasiswa.setSma(view.getFieldSMA().getText());

            view.getFieldNRP().setText("");
            view.getFieldNama().setText("");
            view.getFieldAngkatan().setText("");
            view.getFieldSMA().setText("");

            manager.merge(tbMahasiswa);
            view.getTableModelMahasiswa().update(index, tbMahasiswa);

            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void delete() {
        int index = view.getTableMahasiswa().getSelectedRow();
        if (index == -1){
            return;
        }

        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
        manager.getTransaction().begin();
        try {
            Mahasiswa tbMahasiswa = view.getTableModelMahasiswa().select(index);

            manager.remove(manager.merge(tbMahasiswa));
            view.getTableModelMahasiswa().delete(index);

            manager.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void select() {
        EntityManager manager = PersistenceHelper.getFactory().createEntityManager();
        try {
            @SuppressWarnings("unchecked")
            List list = manager.createQuery("SELECT m FROM Mahasiswa m").getResultList();
            view.getTableModelMahasiswa().updateAll(list);
        } finally {
            manager.close();
        }
    }


}
