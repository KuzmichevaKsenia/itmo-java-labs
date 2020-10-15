package factory;

public class PortFactory implements CustomsFactory {
    @Override
    public Customs getCustoms() {
        return new Port();
    }
}
