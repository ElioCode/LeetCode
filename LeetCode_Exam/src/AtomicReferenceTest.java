import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 15);
        atomicReference.set(user);
        User updateUser = new User("shi", 12);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(user.getName());
    }

    static class User {
        String name;
        int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
