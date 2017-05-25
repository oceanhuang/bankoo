package io.github.oceanhuang.bankoo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import org.chromium.IsReadyToPayService;
import org.chromium.IsReadyToPayServiceCallback;

public class IsReadyToPayServiceImpl extends Service {
    private final IsReadyToPayService.Stub mBinder =
            new IsReadyToPayService.Stub() {
                @Override
                public void isReadyToPay(IsReadyToPayServiceCallback callback) {
                    // Check permission here.
                    try {
                        callback.handleIsReadyToPay(true);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            };

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("IsReadyToPayService", "something happened");
        return mBinder;
    }
}
