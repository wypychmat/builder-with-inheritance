package candy;

import java.lang.reflect.Constructor;
import java.util.Objects;

public class Candy_V1 {
    private String name;
    private int cost;

    protected Candy_V1(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static <T extends AbstractBuilder<T, C>, C extends Candy_V1> T builder(Class<T> builderClass) {
        try {
            Constructor<?> constructor = builderClass.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return builderClass.cast(constructor.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("CANNOT CAST TYPE BUILDER");
    }

    protected abstract static class AbstractBuilder<T extends AbstractBuilder<T, C>, C extends Candy_V1> {
        protected String name;
        protected int cost;

        public T setName(String name) {
            this.name = name;
            return thisObject();
        }

        public T setCost(int cost) {
            this.cost = cost;
            return thisObject();
        }

        protected abstract T thisObject();

        public abstract C build();
    }

    public static class Builder extends AbstractBuilder<Builder, Candy_V1> {

        @Override
        protected Builder thisObject() {
            return this;
        }

        public Candy_V1 build() {
            return new Candy_V1(name, cost);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy_V1 candy_v1 = (Candy_V1) o;
        return cost == candy_v1.cost && Objects.equals(name, candy_v1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
