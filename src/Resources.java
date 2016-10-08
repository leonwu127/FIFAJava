/**
 * Created by leonwu127 on 24/09/2017.
 */
class Resources {
    public String Validate;

    public String Auth;

    public String Home;

    public String NucleusId;

    public String Shards;

    public String AccountInfo;

    public String Item;

    public String PlayerImage;

    public String FlagsImage;

    public String ClubImage;

    public String FutHome = "https://utas.s2.fut.ea.com/ut/game/fifa17/";

    public final String FutHomeXbox = "https://utas.s3.fut.ea.com/ut/game/fifa17/";

    public final String ValidateXbox = "https://utas.s3.fut.ea.com/ut/game/fifa17/phishing/validate";

    public final String AuthXbox = "https://utas.s3.fut.ea.com/ut/auth?timestamp={0}";

    public final String AccountInfoXbox = "https://utas.s3.fut.ea.com/ut/game/fifa17/user/accountinfo?sku=FUT17AND&_={0}";

    public final String POWAuth = "https://pas.mob.v3.easfc.ea.com:8095/pow/auth?timestamp={0}";

    public final String AuthCode = "https://accounts.ea.com/connect/auth";

    public final String CaptchaImage = "https://www.easports.com/iframe/fut17/p/ut/captcha/img?token=AAAA&_={0}";

    public final String CaptchaValidate = "https://www.easports.com/iframe/fut17/p/ut/captcha/validate";

    public final String Token = "https://accounts.ea.com/connect/token";

    public final String Pid = "https://gateway.ea.com/proxy/identity/pids/me";

    public final String LoggedIn = "https://www.easports.com/fifa/api/isUserLoggedIn";

    public final String BaseShowoff = "http://www.easports.com/iframe/fut17/?baseShowoffUrl=https%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Fultimate-team%2Fweb-app%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Fultimate-team%2Fweb-app&locale=en_GB";

    public final String PriceRange = "marketdata/item/pricelimits?itemIdList={0}";

    public final String MyClub = "club?level=10";

    public final String TransferMarket = "transfermarket";

    public final String Bid = "trade/{0}/bid";

    public final String TradeStatus = "trade/status?tradeIds={0}";

    public final String Credits = "user/credits";

    public final String Auctionhouse = "auctionhouse";

    public final String TradePile = "tradepile";

    public final String Watchlist = "watchlist";

    public final String PurchasedItems = "purchased/items";

    public final String ListItem = "item";

    public final String QuickSell = "item?itemIds={0}";

    public final String RemoveFromTradePile = "trade/{0}";

    public final String PileSize = "clientdata/pileSize";

    public final String Consumables = "club/stats/consumables";

    public final String SquadList = "squad/list";

    public final String SquadDetails = "squad/{0}";

    public final String ReList = "/relist";

    public final String ActiveMessageList = "activeMessage";

    public final String ActiveMessageGet = "activeMessage/{0}";

    public final String Definition = "defid?type=player&count=35&start=0&defId={0}";

    public Resources (AppVersion appVersion){
        switch (appVersion){
            case WebApp:
                Validate = "https://www.easports.com/iframe/fut17/p/ut/game/fifa17/phishing/validate";

                Auth = "https://www.easports.com/iframe/fut17/p/ut/auth";

                Home = "https://www.easports.com/fifa/ultimate-team/web-app";

                NucleusId = "https://www.easports.com/iframe/fut17/?locale=en_US&baseShowoffUrl=https%3A%2F%2Fwww.easports.com%2Ffifa%2Fultimate-team%2Fweb-app%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Ffifa%2Fultimate-team%2Fweb-app";

                Shards = "https://www.easports.com/iframe/fut17/p/ut/shards/v2?_={0}";

                AccountInfo = "https://www.easports.com/iframe/fut17/p/ut/game/fifa17/user/accountinfo?sku=FUT17WEB&_={0}";

                Item = "https://fifa15.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/web/{0}.json";

                PlayerImage = "http://fifa15.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/players/web/{0}.png";

                FlagsImage = "http://fifa15.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/cardflagssmall/web/{0}.png";

                ClubImage = "http://fifa15.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/clubbadges/web/dark/s{0}.png";

                break;
            case CompaionApp:
                Validate = "https://utas.s2.fut.ea.com/ut/game/fifa17/phishing/validate";

                Auth = "https://utas.s2.fut.ea.com/ut/auth?timestamp={0}";

                Home = "https://accounts.ea.com/connect/auth?client_id=FIFA-17-MOBILE-COMPANION&response_type=code&display=web2/login&scope=basic.identity+offline+signin&locale=en_GB&prompt=login&machineProfileKey={0}";

                NucleusId = "https://pas.mob.v3.easfc.ea.com:8095/pow/user/self/tiergp/NucleusId/tiertp/{0}?offset=0&count=50&_={1}";

                Shards = "https://utas.mob.v3.fut.ea.com/ut/shards/v2?_={0}";

                AccountInfo = "https://utas.s2.fut.ea.com/ut/game/fifa17/user/accountinfo?sku=FUT17AND&_={0}";

                Item = "https://fifa17.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/web/{0}.json";

                PlayerImage = "http://fifa17.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/players/web/{0}.png";

                FlagsImage = "http://fifa17.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/cardflagssmall/web/{0}.png";

                ClubImage = "http://fifa17.content.easports.com/fifa/fltOnlineAssets/B488919F-23B5-497F-9FC0-CACFB38863D0/2017/fut/items/images/clubbadges/web/dark/s{0}.png";

                break;
        }
    }


}

enum AppVersion{
    WebApp,
    CompaionApp
}