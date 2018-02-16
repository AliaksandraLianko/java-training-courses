package com.company.award;



public class Award {
    static {
        System.out.println("Static init block for Award");
    }
    {
        System.out.println("Instance initialization " + this.getValue());
    }

    private final int value;
    /**
     * Soli is a coefficient to calculate final award value
     */
    private double soli;

    private String type;
    private int id;

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {

        return type;
    }

    public int getId() {
        return id;
    }

    public Award(int value) {
        this.value = value;
        System.out.println("Constructor init " + this.value);
    }

    public Award(int value, double soli) {
        this.value = value;
        this.soli = soli;
    }

    public Award(int value, String type, int id) {
        this.value = value;
        this.type = type;
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setSoli(double soli) {
        this.soli = soli;
    }

    public double getSoli() {
        return soli;
    }

    @Override
    public String toString() {
        return "Award{" +
                "value=" + value +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Award award = (Award) o;

        if (value != award.value) return false;
        if (Double.compare(award.soli, soli) != 0) return false;
        if (id != award.id) return false;
        return type != null ? type.equals(award.type) : award.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = value;
        temp = Double.doubleToLongBits(soli);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
