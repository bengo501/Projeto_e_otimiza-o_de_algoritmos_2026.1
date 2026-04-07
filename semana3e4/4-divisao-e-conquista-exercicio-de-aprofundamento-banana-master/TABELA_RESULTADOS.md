# Resultados dos Testes
# Tabela de Resultados
| Algoritmo | Tamanho | Iterações | Tempo (ms) | Correto |
|-----------|---------|-----------|-----------|---------|
| Merge Sort | 32 | 383 | 0.06 | CORRETO |
| | 2048 | 49,152 | 4.52 | CORRETO |
| | 1.048.576 | 44,040,192 | 318.15 | CORRETO |
| MaxVal1 (Linear) | 32 | 32 | 0.01 | CORRETO |
| | 2048 | 2048 | 0.03 | CORRETO |
| | 1.048.576 | 1,048,576 | 10.25 | CORRETO |
| MaxVal2 (D&C) | 32 | 31 | 0.02 | CORRETO |
| | 2048 | 2047 | 0.05 | CORRETO |
| | 1.048.576 | 1,048,575 | 6.48 | CORRETO |
| Multiplicação | 4 bits | 16 | 0.01 | CORRETO |
| | 16 bits | 256 | 0.02 | CORRETO |
| | 64 bits | 4096 | 0.15 | CORRETO |
| Multiplicação (Strings) | 4 bits | 16 | 0.05 | CORRETO |
| | 16 bits | 256 | 0.08 | CORRETO |
| | 64 bits | 4096 | 0.32 | CORRETO |

# obs
- Merge Sort: 
Crescimento O(n log n) em iterações, todos os testes corretos
- MaxVal1 vs MaxVal2:
 MaxVal1 é O(n), MaxVal2 é O(log n). MaxVal2 é mais eficiente para grandes vetores
- Multiplicação:
 Algoritmo de divisão e conquista funciona corretamente para todos os tamanhos
- Strings: 
Versão com strings tem overhead maior devido ao processamento de strings

