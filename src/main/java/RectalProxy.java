import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RectalProxy implements Rectal, Subscriber {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(RectalProxy.class.getName());
        Handler fileHandler;
        try {
            fileHandler = new FileHandler("C:\\Users\\g0n3r\\java_projects\\Design patterns\\final project\\Patterns\\src\\main\\resources\\logs.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileHandler.setLevel(Level.ALL);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
    }

    private RectalImpl realRectal;
    private boolean access = false;

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public void update(Object state) {
        Department department = (Department) state;
        realRectal = new RectalImpl(department.getStudents(), department);
    }

    @Override
    public void checkStudents() {
        if (access) {
            logger.info("Rectal working");
            realRectal.checkStudents();
        } else {
            logger.info("There is no access to rectal");
        }
    }
}