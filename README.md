# bankoo
Trying Chrome's implementation of [W3C Payment Handler API spec](https://www.w3.org/TR/payment-handler/)

You can find out more details about Chrome's implementation here [g.co/payappintegration](g.co/payappintegration). 

## Demo (Chrome 60+)
1. Make sure you have latest version of Chrome (At the time of writing, I tested on Chrome Dev 60.0.3107.3)
2. Download the app-debug.apk to your Android device
3. Open this [link](https://oceanhuang.github.io/bankoo/test-checkout.html) on Chrome
4. You should see a `Buy` button
5. Tapping the `Buy` button should bring up the Bankoo app. You should also see some info passed in as part of the JS
6. Tapping the `Continue` button should navigate user back to Chrome. You should also see some info passed back from the app

![demo](https://cloud.githubusercontent.com/assets/3765458/26438312/3d930c68-40f0-11e7-93c4-93098368e263.gif)

## Try it yourself?

You can find the source code I used under `bankoo-android` and `bankoo-backend` folders
