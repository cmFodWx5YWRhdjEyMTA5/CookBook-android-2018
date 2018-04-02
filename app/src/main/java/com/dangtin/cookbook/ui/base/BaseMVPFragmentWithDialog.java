package com.dangtin.cookbook.ui.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dangtin.cookbook.R;
import com.dangtin.cookbook.common.Optional;
import com.dangtin.cookbook.utils.Utils;

public abstract class BaseMVPFragmentWithDialog extends BaseFragment implements BaseScreenMvpView {

    protected MaterialDialog progressDialog, alertDialog;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createProgressDialog();
        createAlertDialog();
    }

    @Override
    public void createProgressDialog() {
        progressDialog = Utils.createProgress(getActivity(), null);
    }

    @Override
    public void createAlertDialog() {
        alertDialog = Utils.createAlertDialog(getActivity(), getString(R.string.title_dialog));
    }

    @Override
    public void showProgressDialog(boolean value) {
        if (value) {
            if (progressDialog != null && !progressDialog.isShowing()) {
                progressDialog.show();
                progressDialog.setCancelable(false);
            }
        } else {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void showAlert(String s) {
        showMessage(s);
    }

    @Override
    public void showAlertDialog(String errorMessage) {
        Optional.invoke(alertDialog, dialog -> {
            dialog.setContent(errorMessage);
            dialog.show();
        });
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            alertDialog.dismiss();
        }
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        dismissProgressDialog();
        progressDialog = null;
        alertDialog = null;
        super.onDestroyView();
    }

    protected abstract void initToolbar();

    public void showNoNetworkAlert() {
        showAlertDialog(getString(R.string.error_not_connect_to_internet));
    }

    public boolean isConnectToInternet() {
        return Utils.isConnectivityAvailable(getContext());
    }

    @Override
    public void showAlertDialog(int resourceId) {
        alertDialog.setContent(resourceId);
        alertDialog.show();
    }

    @Override
    public void showAlert(int resourceId) {
        showMessage(resourceId);
    }
}
