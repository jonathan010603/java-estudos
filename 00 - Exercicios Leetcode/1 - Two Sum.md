https://leetcode.com/problems/two-sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

```java
// O objetivo era analisar um Array de números e retornar os índices dos dois números que, somados, resultavam no segundo parâmetro
// Resolvi com um for que itera sobre o Array dentro de outra iteração, subtrai o número atual de target e busca o resultado dessa subtração dentro do array
// Caso o encontre, salva os índices em um Array de resultados, parando as iterações.
// * Foi adicionada uma verificação que barra índices iguais entre a primeira e a segunda iteração, para garantir que o mesmo número seja selecionado

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];

        for (int firstIterationIndex = 0; firstIterationIndex < nums.length; firstIterationIndex++) {
            int objective = target - nums[firstIterationIndex];

            for (int secondIterationIndex = 0; secondIterationIndex < nums.length; secondIterationIndex++) {
                if (firstIterationIndex != secondIterationIndex) {
                    if (objective == nums[secondIterationIndex]) {
                        results[0] = firstIterationIndex;
                        results[1] = secondIterationIndex;
                        break;
                    }
                }
            }
        }

        return results;
    }
}
```