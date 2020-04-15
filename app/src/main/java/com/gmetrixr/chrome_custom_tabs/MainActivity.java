package com.gmetrixr.chrome_custom_tabs;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private ChromeCustomTabsJwt chromeCustomTabs;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setWindow();
    setContentView(R.layout.activity_main);
    this.attachEventHandlers();
    this.prepareChromeTabs();
  }

  private void setWindow() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
  }

  private void attachEventHandlers() {
    Button startCourse = (Button) findViewById(R.id.openSafeHands);
    startCourse.setOnClickListener(this);
  }

  private void prepareChromeTabs() {
    chromeCustomTabs = new ChromeCustomTabsJwt();
    String url = "https://view.gmetri.com/v4/game/safehands_v2";
    chromeCustomTabs.initialize(url, this);
  }

  @Override
  public void onClick(View v) {
    chromeCustomTabs.launch();
  }
}
