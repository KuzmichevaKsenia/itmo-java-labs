package factory;

public class AirportFactory implements CustomsFactory{
    @Override
    public Customs getCustoms() {
        return new Airport();
    }
}
