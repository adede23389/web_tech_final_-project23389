/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Access.userAccess;
import Car.CarRent;
import Car.cardetails;
import HibernateUtil.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import registrtion.user;

/**
 *
 * @author Bonheur
 * @param <T>
 */
public class GenericDao<T extends Serializable> implements IgenericDao<T> {

    @Override
    public void create(T x) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(x);
        ss.getTransaction().commit();
        ss.close();
    }

    @Override
    public void delete(T x) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(x);
        ss.getTransaction().commit();
        ss.close();
    }

    @Override
    public void update(T x) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(x);
        ss.getTransaction().commit();
        ss.close();

    }

    @Override
    public List<T> getAll(String tableName) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<T> All = ss.createQuery(tableName).list();
        ss.clear();
        return All;
    }

    @Override
    public T get(Class<T> x, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    public ExpanceAsset getOneExpanceAsset(int id){
//        return (ExpanceAsset) HibernateUtil.getSession().get(ExpanceAsset.class,id);
//    
//    }
//
//    public clientinf getOneClient(int id) {
//        return (clientinf) HibernateUtil.getSession().get(clientinf.class, id);
//    }
//     public InsidentLif getOneClientApp(int id) {
//        return (InsidentLif) HibernateUtil.getSession().get(InsidentLif.class, id);
//    }
//      public InsidentMotovehicle getOneClientMotoVehApp(int id) {
//        return (InsidentMotovehicle) HibernateUtil.getSession().get(InsidentMotovehicle.class, id);
//    }
//       public Dependence getOneClientlifeDepApp(int id) {
//        return (Dependence) HibernateUtil.getSession().get(Dependence.class, id);
//    }
//           public usersystem getOnesystmeUse(int id) {
//        return (usersystem) HibernateUtil.getSession().get(usersystem.class, id);
//    }
    public user getOneUser(int id) {
                        System.out.println("id in dao is if "+id);

        return (user) HibernateUtil.getSession().get(user.class, id);
    }
    public cardetails getOneCar(int id) {
        return (cardetails) HibernateUtil.getSession().get(cardetails.class, id);
    }
    
       public CarRent getOneCarrent(int id) {
        return (CarRent) HibernateUtil.getSession().get(CarRent.class, id);
    }
        public userAccess getOneUserAccess(int id) {
        return (userAccess) HibernateUtil.getSession().get(userAccess.class, id);
    }
//      public SystUserInfo getOneSystUser(int id) {
//        return (SystUserInfo) HibernateUtil.getSession().get(SystUserInfo.class, id);
//    }
//              public SuppliesInfo getOneSupplier(int id) {
//        return (SuppliesInfo) HibernateUtil.getSession().get(SuppliesInfo.class, id);
//    }
//                     public Location getOneLocation(int id) {
//        return (Location) HibernateUtil.getSession().get(Location.class, id);
//    }
//                          public EmpUserInfo getOneEmpUserInfo(int id) {
//        return (EmpUserInfo) HibernateUtil.getSession().get(EmpUserInfo.class, id);
//    }
//                              public Category getOneCategory(int id) {
//        return (Category) HibernateUtil.getSession().get(Category.class, id);
//    }
//                                    public Asset getOneAsset(int id) {
//        return (Asset) HibernateUtil.getSession().get(Asset.class, id);
//    }     public ExpanceAsset getOnExpanceasset(int id) {
//        return (ExpanceAsset) HibernateUtil.getSession().get(ExpanceAsset.class, id);
//    }
}
