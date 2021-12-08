import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {


    public static final Logger log = Logger.getLogger(BasePage.class);
    
    @Step("<saniye> saniye beklendi")
    public void saniyeBekle(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
        log.info(wait + " saniye bekledi !!!");
    }

    @Step("<idControl> logo kontrolu")
    public void ozdilekLogo(String logoId){
        Assert.assertTrue("Uygulama calismadi,Logo bulunamadi",appiumDriver.findElement(By.id(logoId)).isDisplayed());
        log.info("Uygulama calisti, Logo bulundu");
    }

    @Step("<selectorid> alisverise basla butonuna basilir")
    public void alisveriseBasla(String selectorid) {
        appiumDriver.findElement(By.id(selectorid)).click();
        log.info("Alisverise basla butonuna basildi");
    }

    @Step("<idControl> market butonu kontrolu")
    public void marketButonu(String marketButonu) {
        Assert.assertTrue("Alisveris sayfasi acilmadi,Market butonu bulunamadi", appiumDriver.findElement(By.id(marketButonu)).isDisplayed());
        log.info("Alisveris sayfasi acildi,Market butonu bulundu");
    }

    @Step("<selectorid> katagoriler butonuna tikla")
    public void katagoriButonuTikla(String selectorid) {
        appiumDriver.findElement(By.id(selectorid)).click();
        log.info("Katagoriler butonuna tiklandi");
    }

    @Step("<selectorid> sayfada search inputu kontrolu")
    public void searchInput(String searchInput) {
        Assert.assertTrue("Alisveris sayfasi acilmadi,Search input bulunamadi", appiumDriver.findElement(By.id(searchInput)).isDisplayed());
        log.info("Katagoriler sayfasi acildi,Search input bulundu");
    }

    @Step("<xpath> kadin butonuna tikla")
    public void kadinButonunaTikla(String selectxPath) {
        appiumDriver.findElement(By.xpath(selectxPath)).click();
        log.info("Kadin butonuna tiklandi");
    }

    @Step("<xpath> pantolon butonuna tikla")
    public void pontolonButonunaTikla(String selectxPath) {
        appiumDriver.findElement(By.xpath(selectxPath)).click();
        log.info("Pantolon butonuna tiklandi");
    }

    @Step("<asagi scroll et>")
    public void scrollEt(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(545, 1850)).moveTo(PointOption.point(545, 750)).release().perform();
        log.info("Asagi scrool edildi");
    }

    @Step("rastgele urun sec")
    public void rastgeleUrunSec() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();
        log.info("Rastgele pantolon urunu secildi");
    }

    @Step("<idControl> pantolon urun logosu kontrolu")
    public void pantolonLogo(String pantolonLogo) {
        Assert.assertTrue("Pantolon detay sayfasi acilmadi,Pantolon Logo bulunamadi", appiumDriver.findElement(By.id(pantolonLogo)).isDisplayed());
        log.info("Pantolon detay sayfasi acildi,Pantolon Logo bulundu");
    }

    @Step("<selectorid> favoriler butonuna tiklanir")
    public void urunFavoriEkle(String favoriUrun) {
        appiumDriver.findElement(By.id(favoriUrun)).click();
        log.info("Favoriler butonu tiklandi");
    }

    @Step("<idControl> girisYap butonu kontrol")
    public void girisYapButon(String girisYapButonu) {
        Assert.assertTrue("GirisYap butonu bulunamadi", appiumDriver.findElement(By.id(girisYapButonu)).isDisplayed());
        log.info("GirisYap butonu bulundu");
    }

    @Step("<selectorid> giris inputa <text> email gir")
    public void mailGir(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        log.info("Email girildi");
    }

    @Step("<selectorid> sifre inputa <text> sifre gir")
    public void sifreGir(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        log.info("Sifre girildi");
    }

    @Step("<id> geri butonuna basilir")
    public void geriButonuBas(String geri){
        appiumDriver.findElement(By.id(geri)).click();
        log.info("Geri gidildi");
    }

    @Step("<selectorid> sepete ekle butonu basilir")
    public void sepeteEkleButonuBas(String sepeteEkle) {
        appiumDriver.findElement(By.id(sepeteEkle)).click();
        log.info("Sepete ekle butonuna basildi");
    }
}

