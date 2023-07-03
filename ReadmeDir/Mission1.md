# 학습 목표
기본적인 자바 문법을 이해하고 자바로 작성한 코드를 실행할 수 있다.

JUnit을 활용한 테스트 코드를 작성할 수 있다.

# 사전지식
## 기능요구사항
1. 체스 게임을 시작하는 프로젝트를 생성한다.

2. 체스 게임에서 가장 힘이 약하면서 기본 말 중의 하나인 폰(pawn)에서 게임 구현을 시작한다.

3. 폰을 생성할 때 어느 팀의 말인지 구분하기 위해 흰색(white)과 검은색(black)으로 구분해 생성할 수 있도록 한다.

# 프로그래밍 요구사항
## 구현 시작하기
체스 게임 중에서 가장 기본 말인 폰(pawn)을 대표하는 Pawn 클래스에서 시작한다.

1. Pawn 테스트 

## PawnTest 클래스 생성
- [X] PawnTest 클래스 생성
- [X] PawnTest를 JUnit으로 실행한다. 테스트 메소드를 구현하지 않았기 때문에 실패하는 것을 확인한다.
- [X] create라는 테스트 메소드를 생성한다.
- [X] JUnit 테스트 메소드를 생성한 후 테스트 메소드를 실행해 앞 단계의 실패가 성공하는 것을 확인한다.

## create() 테스트 메소드 작성
- [X] DisplayName 어노테이션을 잘 활용하자.
- [X] PawnTest의 create() 메소드에서 Pawn 인스턴스를 생성하고 컴파일이 성공하도록 구현한다.
- [X] Pawn을 생성할 때 흰색과 검은색 값을 가지도록 인스턴스를 생성한다.
- [X] 흰색(white)을 값으로 가지는 Pawn을 생성한 후 AssertJ의 assert() 메소드를 활용해 테스트가 실패하는지 확인한다.

```java
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }
}
```

2. Pawn 클래스 구현
테스트가 성공하도록 Pawn을 구현한다.

## 검은색 폰 생성
- [ ] PawnTest의 create() 메소드에 두 번째 Pawn을 생성하고 "black"이라는 값을 생성자로 전달한다.

- [ ] 두 번째 Pawn의 색이 "black"인지 검증한다.

- [ ] 만약 테스트가 실패하면 테스트가 성공하도록 Pawn을 수정한다.

3. 리팩토링
- [ ] PawnTest의 create()에서 "white", "black" 문자열 값이 중복된다.

- [ ] "white", "black" 문자에 대한 중복을 제거하기 위해 create() 메소드에 local variable을 추가한다.

- [ ] 수정 후 테스트가 성공하는지 확인한다.

- [ ] PawnTest를 보면 흰색과 검은색 Pawn을 생성하고 결과 값을 확인하는 부분에도 중복이 있다.

- [ ] verifyPawn(final String color)와 같은 메소드를 추가해 중복 코드를 제거해 본다.

## PR 보내기
- [ ] 완료후 PR을 보내자.

- [ ] 본인 ID 브랜치로 PR 보내는 것을 잊지 말자.