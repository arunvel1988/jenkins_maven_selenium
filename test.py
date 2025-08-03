
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time

# URL of the Selenium Grid router
SELENIUM_GRID_URL = "http://localhost:4444/wd/hub"

# Chrome options for headless execution
chrome_options = Options()
chrome_options.add_argument("--headless")
chrome_options.add_argument("--no-sandbox")
chrome_options.add_argument("--disable-dev-shm-usage")

# Set capability via options (replaces desired_capabilities)
chrome_options.set_capability("browserName", "chrome")

# Connect to the Selenium Grid
driver = webdriver.Remote(
    command_executor=SELENIUM_GRID_URL,
    options=chrome_options
)

# Run the test
driver.get("https://www.google.com")
print("Page Title:", driver.title)

# Wait and quit
time.sleep(2)
driver.quit()
