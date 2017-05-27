Feature: 启动Appium服务与App
  Scenario: runAppium
    Given StartAppiumServer
  Scenario: runApp
    Given wait element find：com.fulihui.www.information:id/skip_view
    When find element by：com.fulihui.www.information:id/skip_view