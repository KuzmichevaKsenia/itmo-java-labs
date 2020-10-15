package factory;

public class RailStationFactory implements CustomsFactory {
    @Override
    public Customs getCustoms() {
        return new RailStation();
    }
}
