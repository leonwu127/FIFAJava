import fut
import random
from time import time

fut = fut.Core('leonwu127@icloud.com','2013Zhuangyuan','weiwei','xbox')
SAssetId=190460 #Eriksen
SMaxBuyNow=9000 #min value you like to buy

SellMin=9700
SellMax=9800

TotalCoins=fut.credits
i = 0;
while i<500:
    #
    if i%2 == 0:
        SMaxBuyNow = 9000
    else:
        SMaxBuyNow = 9200
    i = i + 1;
    print "Searching for: %d, Coins: %d" % (SMaxBuyNow, TotalCoins)
    if TotalCoins < 1000:
        break;

    items = fut.searchAuctions('player',assetId=SAssetId,max_buy=SMaxBuyNow)
    for item in items:
        if TotalCoins > item['buyNowPrice']:
            fut.bid(item['tradeId'], item['buyNowPrice'])
            print "Found: %d - %s - Maxtime: %d" % (item['tradeId'], item['buyNowPrice'], item['expires'])
            itemsBought = fut.unassigned()
            for itemBought in itemsBought:
                idItem = itemBought['id']
                if fut.sendToTradepile(-1, idItem):
                    print "Listing..."
                    fut.sell(idItem, SellMin, buy_now=SellMax)
                time.sleep(random.randint(5,8))
            TotalCoins = fut.credits
        else:
            print "No coins %s" % (item['buyNowPrice'])
    if TotalCoins<5000:
        time.sleep(600)
    time.sleep(random.randint(1,3))