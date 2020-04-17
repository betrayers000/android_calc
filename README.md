## Button Event loop
- layout.childCount 를 사용하여 layout의 자식 View의 숫자를 가져온다.
- for (i in 0..layout.childCount)를 사용하여 자식 View의 인덱스를 반복으로 추출한다.
- val v = layout.getChildAt(int)를 사용하여 자식 View를 가져온다.
- if (v in Button) 를 통해서 v 가 Button 타입인지 확인하고 click event를 적용한다
