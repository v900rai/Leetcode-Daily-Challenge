class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed.length == 1) {
      return (n == 1 && flowerbed[0] == 0) || (n == 0);
    }
    int appropriatePlace = 0;
    int previousPlace = 0;

    for (int i = 0; i < flowerbed.length - 1; i++) {
      if (flowerbed[i] == 0 && previousPlace == 0 && flowerbed[i + 1] == 0) {
        appropriatePlace++;
        flowerbed[i] = 1;
      }
      previousPlace = flowerbed[i];
    }

    if (flowerbed.length > 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
      appropriatePlace++;
    }

    return appropriatePlace >= n;
  }
}