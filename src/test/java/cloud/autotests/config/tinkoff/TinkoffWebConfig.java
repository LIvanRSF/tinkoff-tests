package cloud.autotests.config.tinkoff;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:config/TinkoffWeb.properties"
})
public interface TinkoffWebConfig extends Config {

    String webUrl();
}
