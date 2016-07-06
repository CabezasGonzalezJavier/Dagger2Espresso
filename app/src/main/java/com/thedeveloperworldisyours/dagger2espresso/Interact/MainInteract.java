package com.thedeveloperworldisyours.dagger2espresso.Interact;

/**
 * Created by javierg on 05/07/16.
 */
public interface MainInteract {
    interface OnMainFinishedListener {

        void onSuccess(String image);

        void onFail();
    }

    void logo(OnMainFinishedListener listener);
}
