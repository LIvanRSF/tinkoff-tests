package cloud.autotests.config.tinkoff;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:config/tinkoffWeb.properties"
})
public interface TinkoffWebConfig extends Config {

    String webUrl();
}
