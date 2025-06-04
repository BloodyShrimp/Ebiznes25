import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

class FrontendTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Chrome()
        cls.driver.get("http://localhost:3000")
        cls.driver.maximize_window()
        time.sleep(2)

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()

    def test_01(self):
        self.assertIn("Sklep Internetowy", self.driver.title)

    def test_02(self):
        heading = self.driver.find_element(By.TAG_NAME, "h1")
        self.assertEqual(heading.text, "Sklep Internetowy")

    def test_03(self):
        produkty = self.driver.find_elements(By.CSS_SELECTOR, "ul li")
        self.assertGreater(len(produkty), 0)

    def test_04(self):
        form = self.driver.find_element(By.TAG_NAME, "form")
        self.assertIsNotNone(form)

    def test_05(self):
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        self.assertEqual(kwota_input.get_attribute("type"), "number")

    def test_06(self):
        produkt_input = self.driver.find_element(By.NAME, "produktId")
        self.assertEqual(produkt_input.get_attribute("type"), "text")

    def test_07(self):
        button = self.driver.find_element(By.TAG_NAME, "button")
        self.assertEqual(button.text, "Wyślij płatność")

    def test_08(self):
        self.fill_form(kwota="50", produkt_id="1")
        alert = self.driver.switch_to.alert
        self.assertIn("Płatność wysłana!", alert.text)
        alert.accept()

    def test_09(self):
        self.fill_form(kwota="", produkt_id="")
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        produkt_input = self.driver.find_element(By.NAME, "produktId")
        self.assertEqual(kwota_input.get_attribute("value"), "")
        self.assertEqual(produkt_input.get_attribute("value"), "")


    def test_10(self):
        button = self.driver.find_element(By.TAG_NAME, "button")
        bg_color = button.value_of_css_property("background-color")
        self.assertTrue(bg_color.startswith("rgba(") or bg_color.startswith("rgb("))

    def test_11(self):
        items = self.driver.find_elements(By.CSS_SELECTOR, "ul li")
        for item in items:
            self.assertIn("-", item.text)

    def test_12(self):
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        kwota_input.send_keys("123")
        self.assertEqual(kwota_input.get_attribute("value"), "123")

    def test_13(self):
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        kwota_input.clear()
        kwota_input.send_keys("abc")
        self.assertEqual(kwota_input.get_attribute("value"), "")

    def test_14_(self):
        produkt_input = self.driver.find_element(By.NAME, "produktId")
        produkt_input.send_keys("123abc")
        self.assertIn("123abc", produkt_input.get_attribute("value"))

    def test_15(self):
        self.fill_form(kwota="75", produkt_id="2")
        alert = self.driver.switch_to.alert
        alert.accept()
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        self.assertEqual(kwota_input.get_attribute("value"), "75")

    def test_16(self):
        headings = self.driver.find_elements(By.TAG_NAME, "h2")
        self.assertEqual(len(headings), 2)

    def test_17(self):
        ul = self.driver.find_element(By.TAG_NAME, "ul")
        self.assertIsNotNone(ul)

    def test_18(self):
        labels = self.driver.find_elements(By.TAG_NAME, "label")
        self.assertGreaterEqual(len(labels), 2)

    def test_19(self):
        produkt_input = self.driver.find_element(By.NAME, "produktId")
        produkt_input.send_keys("testtest")
        produkt_input.clear()
        self.assertEqual(produkt_input.get_attribute("value"), "")

    def test_20(self):
        self.driver.refresh()
        time.sleep(2)
        heading = self.driver.find_element(By.TAG_NAME, "h1")
        self.assertEqual(heading.text, "Sklep Internetowy")

    def fill_form(self, kwota, produkt_id):
        kwota_input = self.driver.find_element(By.NAME, "kwota")
        produkt_input = self.driver.find_element(By.NAME, "produktId")
        kwota_input.clear()
        produkt_input.clear()
        kwota_input.send_keys(kwota)
        produkt_input.send_keys(produkt_id)
        button = self.driver.find_element(By.TAG_NAME, "button")
        button.click()
        time.sleep(1)

if __name__ == "__main__":
    unittest.main()
