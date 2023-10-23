![Alt text](image.png)

# 01 코딩 테스트
- 잘 짠 코드?
    1. 문제를 해결한 코드
    2. 가독성과 효율성

    >- `Stream()` 사용법
    >```
    >people.stream()
    >   .filter(p->p.hasPhoneNumber(number))
    >   .findFirst()
    >   .orElse(null)
    >```
    >여러 반복문을 이용해서 구현해야 할 코드를 매우 간단하게 작성할 수 있게 해준다.
    `Set<Person>`을 `Stream<Person>`로 변환 후, `filter(p->p.hasPhoneNumber(number))`를 사용해서 객체를 찾는다. `findFirst()` 메서드를 호출하여 찾은 객체가 있는지 검사하고 `orElse(null)` 메서드가 없다면 null을 반환하도록 한다.

# 02 시간 복잡도
- 빅오 표기법
    알고리즘이 겪을 수 있는 최악의 경우에 걸리는 시간과 입력 간의 상관관계
>시간 복잡도별 비교 그래프
![Alt text](image-1.png)

# 03 배열
- 예제
    1. [교점에 별 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/87377)
    2. [삼각 달팽이](https://school.programmers.co.kr/learn/courses/30/lessons/68645)
    3. [거리두기 확인하기](https://school.programmers.co.kr/learn/courses/30/lessons/81302)
    4. [행렬의 곱셈](https://school.programmers.co.kr/learn/courses/30/lessons/12949)
