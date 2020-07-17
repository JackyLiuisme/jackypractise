package basic.Enum;


public enum TestEnum {
    MAN,WOMAN;
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
