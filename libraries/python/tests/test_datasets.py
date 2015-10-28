import unittest

from datasets import music

class TestMusic(unittest.TestCase):
 
    def test_get_songs(self):
        songs = music.get_songs()
        print songs
        self.assertEqual( 1, 1)
 
if __name__ == '__main__':
    unittest.main()