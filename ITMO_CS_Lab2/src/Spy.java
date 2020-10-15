public class Spy {
    public String name;
    private String realName;
    private int squad;

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSquad(int squad) {
        this.squad = squad;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public int getSquad() {
        return squad;
    }

    private String getSpyInfo() {
        return (name + ' ' + realName + ' ' + squad);
    }

    public void print() {
        System.out.println(name + ' ' + realName + ' ' + squad);
    }

    // Для демонстрации private метода
    public String getPrivateSpyInf() {
        return getSpyInfo();
    }
}
