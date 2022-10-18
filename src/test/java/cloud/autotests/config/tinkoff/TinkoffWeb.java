package cloud.autotests.config.tinkoff;

import org.aeonbits.owner.ConfigFactory;

public class TinkoffWeb {
    public static TinkoffWebConfig config =
        ConfigFactory.create(TinkoffWebConfig.class, System.getProperties());
}
