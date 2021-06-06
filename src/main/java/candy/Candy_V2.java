package candy;

import java.util.Objects;

public class Candy_V2 extends Candy_V1 {
    private String v2Field;

    protected Candy_V2(String name, int cost, String v2Field) {
        super(name, cost);
        this.v2Field = v2Field;
    }

    public String getV2Field() {
        return v2Field;
    }

    public void setV2Field(String v2Field) {
        this.v2Field = v2Field;
    }

    protected abstract static class AbstractBuilder<T extends AbstractBuilder<T, C>, C extends Candy_V2>
            extends Candy_V1.AbstractBuilder<T, C> {
        protected String v2Field;

        public T setV2Field(String v2Field) {
            this.v2Field = v2Field;
            return thisObject();
        }
    }

    public static class Builder extends AbstractBuilder<Builder, Candy_V2> {

        @Override
        protected Builder thisObject() {
            return this;
        }

        @Override
        public Candy_V2 build() {
            return new Candy_V2(name, cost, v2Field);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy_V2 candy_v2 = (Candy_V2) o;
        return Objects.equals(v2Field, candy_v2.v2Field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), v2Field);
    }
}
