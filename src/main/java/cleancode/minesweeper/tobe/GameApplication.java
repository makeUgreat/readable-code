package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }

    /*
    * DIP (Dependency Inversion Principle)
    * 고수준 모듈이 저수준 모듈에 의존하면 안된다.
    * 구현에 의존하지마 추상화에 의존해
    * 일반적인 흐름이라면 고수준이 저수준을 의존할 수 밖에 없음 ( 고수준 모듈 코드에서 저수준 구현체를 생성하니까 )
    * 이 흐름을 뒤집기 때문에 Inversion
    * 그렇다고 저수준 구현체에서 고수준 구현체를 의존하는 흐름은 아니고
    * 고수준 모듈 <- 추상화 -> 저수준 모듈
    *
    * 스프링에서...
    * DI (Dependency Injection) 역전 아니고 주입임
    * 필요한 의존성을 내가 생성하는게 아니고 외부에서 생성해서 주입받겠다는 뜻
    * A가 B를 사용하고싶을 때 제 3자가 이 둘의 의존성을 맺어줌
    * 스프링과 nestJS 에서는 이 3자를 IOC 컨테이너라고 부름.
    *
    * IOC (Inversion of Control) -> 제어의 역전
    * 제어의 순방향은 개발자가 프로그램을 만드므로 개발자 -> 프로그램으로 감
    * 제어의 역전은 이러한 방향을 뒤집는 것.
    * 프로그램의 흐름을 개발자가 아닌 프레임워크가 담당하도록함
    *
    * */
}
