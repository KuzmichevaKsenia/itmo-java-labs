package first;

// абстрактный класс
abstract class Storage {
    // сохранить данные (абстрактный метод)
    public abstract void store(String data);

    // чтение данных (абстрактный метод)
    public abstract String read();
}

// класс, реализующий абстрактный
class CD extends Storage {
    private String data = "";

    public CD() {
    }

    @Override // реализация
    public void store(String data) {
        this.data += data;
        System.out.println("Data stored on first.CD");
    }

    @Override // реализация
    public String read() {
        return this.data;
    }
}

// класс, реализующий абстрактный
class SDCard extends Storage {
    private String data = "";

    public SDCard() {
    }

    @Override // реализация
    public void store(String data) {
        this.data += data;
        System.out.println("Data stored on first.SDCard");
    }

    @Override // реализация
    public String read() {
        return this.data;
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        // создание объекта first.CD
        CD cd = new CD();
        cd.store("Some data to first.CD");
        System.out.println(cd.read());
        // создание объекта first.SDCard
        SDCard sd = new SDCard();
        sd.store("Some data to first.SDCard");
        System.out.println(sd.read());
        // попытка создать объект класса first.Storage
        // требует реализации абстрактных методов
        Storage storage = new Storage() {
            private String data = "";

            @Override
            public void store(String data) {
                this.data += data;
                System.out.println("Data stored on storage");
            }

            @Override
            public String read() {
                return this.data;
            }
        };
        storage.store("Some data to storage");
        System.out.println(storage.read());
    }

}
