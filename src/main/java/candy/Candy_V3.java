package candy;

import java.util.Objects;

public class Candy_V3 extends Candy_V2 {
    private String v3Field;

    protected Candy_V3(String name, int cost, String v2Field, String v3Field) {
        super(name, cost, v2Field);
        this.v3Field = v3Field;
    }

    public void setV3Field(String v3Field) {
        this.v3Field = v3Field;
    }

    public String getV3Field() {
        return v3Field;
    }

    protected abstract static class AbstractBuilder<T extends AbstractBuilder<T, C>, C extends Candy_V3>
            extends Candy_V2.AbstractBuilder<T, C> {
        protected String v3Field;

        public T setV3Field(String v3Field) {
            this.v3Field = v3Field;
            return thisObject();
        }
    }

    public static class Builder extends AbstractBuilder<Builder, Candy_V3> {

        @Override
        protected Builder thisObject() {
            return this;
        }

        @Override
        public Candy_V3 build() {
            return new Candy_V3(name, cost, v2Field, v3Field);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy_V3 candy_v3 = (Candy_V3) o;
        return Objects.equals(v3Field, candy_v3.v3Field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), v3Field);
    }
}
