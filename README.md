# Mines Finder

O Mines Finder é um jogo cujo desafio é descobrir minas escondidas num campo retangular.

## 🎮 Funcionalidades

- **Iniciar Jogo**: Inicie um novo jogo consoante o nível de dificuldade escolhido (fácil, médio ou difícil).

- **Marcar Quadrícula com Mina**: O jogador pode marcar uma quadrícula acreditando que esta contenha uma mina.

- **Marcar Quadrícula como Duvidosa**: Em caso de incerteza, é possível marcar a quadrícula como duvidosa.

- **Revelar Quadrícula**: Revele uma quadrícula que não tenha sido previamente marcada. Ao fazer isto, várias situações podem surgir:
  - Quadrícula contém uma mina: O jogador perde.
  - Quadrícula não tem mina, mas tem minas nas adjacências: Mostra-se o número de minas adjacentes.
  - Sem minas nas adjacências: Todas as quadrículas adjacentes não marcadas serão reveladas.

- **Terminar o Jogo**: O jogo acaba se o jogador perder ou se todas as quadrículas sem minas forem reveladas. Se completar o jogo num tempo inferior ao das tentativas anteriores no mesmo nível de dificuldade, o nome e o tempo do jogador serão registados como novo recorde.

## 🔢 Níveis de Dificuldade

O nível de dificuldade determina a dimensão do campo e o número de minas escondidas.

| Nível de Dificuldade | Largura | Altura | Número de Minas |
|----------------------|---------|--------|-----------------|
| Fácil                | 9       | 9      | 10              |
| Médio                | 16      | 16     | 40              |
| Difícil              | 16      | 30     | 90              |
