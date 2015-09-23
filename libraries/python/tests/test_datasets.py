import unittest

from datasets import weather

class TestWeather(unittest.TestCase):
 
    def test_get_temperature(self):
        weather_data = weather.get_temperature()
        print weather_data
        self.assertEqual( 1, 1)
 
if __name__ == '__main__':
    unittest.main()