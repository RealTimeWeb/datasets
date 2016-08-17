import unittest
from {{ metadata.name | snake_case }} import {{ metadata.name | snake_case }}

class Test{{ metadata.name | camel_case_caps }}(unittest.TestCase):
    
    {% for function in functions %}
    def test_{{ function.name | snake_case }}_online(self):
        {{ metadata.name | snake_case }}.connect()
        t = {{ metadata.name | snake_case }}.{{ function.name | snake_case }}('AAPL')
        self.assertTrue(t)
        
    def test_{{ function.name | snake_case }}_offline(self):
        {{ metadata.name | snake_case }}.disconnect()
        {{ metadata.name | snake_case }}.{{ function.name | snake_case }}()
        self.assertTrue()
    {% endfor %}


if __name__ == '__main__':
    unittest.main()