import models.DAO;
import models.DTO;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DAO dao = new DAO();
        DTO car = dao.findById(8);

////        CRUD
//        DTO car = new DTO();
//        dao.create(car);
//
//        DTO getCar = dao.findById(1);
//        System.out.println("retrieved car: " + getCar.getMake() + " " + getCar.getModel());
//
//        car.setMake("audi");
//        car.setModel("s7");
//        dao.update(car);
//
//        List<DTO> cars = dao.findAll();
//        System.out.println("All cars:");
//        for (DTO c : cars) {
//            System.out.println(c.getMake() + " " + c.getModel());
//        }
//
//        dao.delete();
    }
}
