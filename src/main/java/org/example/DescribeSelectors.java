package org.example;

public class DescribeSelectors {

    //MainPage
    /*
    НИЖНЯЯ кнопка заказа на основной странице
    By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    Кнопка куков
    By.id("rcc-confirm-button");
    Далее перечислены селекторы для кнопок вопросов о важном
    сколько это стоит и как оплатить?
    By.id("accordion__heading-0");
    Хочу сразу несколько самокатов! Так можно?
    By.id("accordion__heading-1");
    Как рассчитывается время аренды?
    By.id("accordion__heading-2");
    Можно ли заказать самокат прямо на сегодня?
    By.id("accordion__heading-3");
    Можно ли продлить заказ или вернуть самокат раньше?
    By.id("accordion__heading-4");
    Вы привозите зарядку вместе с самокатом?
    By.id("accordion__heading-5");
    Можно ли отменить заказ?
    By.id("accordion__heading-6");
    Я жизу за МКАДом, привезёте?
    By.id("accordion__heading-7");
    А вот тут перечислить селекторы уже текста в выпадашках
    By.xpath(".//div [@id = 'accordion__panel-0']/p");
    Хочу сразу несколько самокатов! Так можно?
    By.xpath(".//div [@id = 'accordion__panel-1']/p");
    Как рассчитывается время аренды?
    By.xpath(".//div [@id = 'accordion__panel-2']/p");
    Можно ли заказать самокат прямо на сегодня?
    By.xpath(".//div [@id = 'accordion__panel-3']/p");
    Можно ли продлить заказ или вернуть самокат раньше?
    By.xpath(".//div [@id = 'accordion__panel-4']/p");
    Вы привозите зарядку вместе с самокатом?
    By.xpath(".//div [@id = 'accordion__panel-5']/p");
    Можно ли отменить заказ?
    private By orderCancellation = By.xpath(".//div [@id = 'accordion__panel-6']/p");
    Я жизу за МКАДом, привезёте?
    By.xpath(".//div [@id = 'accordion__panel-7']/p");
    */

    //OrderConfirmationModal
    /*
    Само окошко
    By.xpath(".//div [@class = 'Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ')]");
    Кнопка "Да"
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");
    Кнопка "Нет"
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Нет')]");
     */

    //OrderStatus
    /*
    Поле ввода номера заказа для поиска
    By.className("Input_Input__1iN_Z.Track_Input__1g7lq.Input_Responsible__1jDKN");
    Кнопка для поиска по номеру заказа
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Посмотреть')]");
    Кнопка для отмены заказа
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Отменить заказ')]");
    Картинка с предупреждением что заказ не найден
    By.xpath(".//img [@src = '/assets/not-found.png']");
    имя
    By.xpath(".//div[@class = 'Track_Row__1sN1F']/div[@class = 'Track_Title__1XfhB' and contains(text(), 'Имя')]/following-sibling::div[@class='Track_Value__15eEX']");
    фамилия
    By.xpath(".//div[@class = 'Track_Row__1sN1F']/div[@class = 'Track_Title__1XfhB' and contains(text(), 'Фамилия')]/following-sibling::div[@class='Track_Value__15eEX']");
     */

    //RentalDetails
    /*
    Сама форма
    By.xpath(".//div[@class = 'Order_Header__BZXOb' and contains(text(), 'Про аренду')]");
    Когда привезти самокат
    By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    Календарь Выпадашка
    By.className("react-datepicker__month-container");
    нужный день в календаре
    pBy.className("react-datepicker__day--selected");
    Период аренды
    By.className("Dropdown-root");
    Выпадающий список
    By.className("Dropdown-menu");
    1 сутки
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    2 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'двое суток')]");
    3 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    4 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'четверо суток')]");
    5 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'пятеро суток')]");
    6 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'шестеро суток')]");
    7 суток
    By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'семеро суток')]");
    Цвет
    By.className("Order_Checkboxes__3lWSI");
    Цвет черный жемчуг
    By.id("black");
    Цвет серая безысходность
    By.id("grey");
    Комментарий для курьера
    By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    Кнопка Назад
    By.cssSelector("Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");
    Кнопка Заказать
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
     */

    //SiteHeader
    /*
    лого Яндекса
    By.className("Header_LogoYandex__3TSOI");
    лого Самоката
    By.className("Header_LogoScooter__3lsAR");
    Кнопка заказа
    By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    Кнопка статуса заказа Header_Link__1TAG7
    By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Header_Link__1TAG7']");
    поле ввода номера заказа в шапке
    By.xpath(".//input[@class = 'Input_Input__1iN_Z Header_Input__xIoUq' and @placeholder = 'Введите номер заказа']");
    странная кнопка GO
    By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO' and contains (text(), 'Go!')]");
     */

    //StatusModal
    /*
    Кнопка "Посмотреть статус"
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Посмотреть статус')]");
    Само окошко
    By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and contains(text(), 'оформлен')]");
     */

    //WhoIsTheScooterFor
    /*
    Имя
    By.xpath(".//input[@placeholder = '* Имя']");
    Фамилия
    By.xpath(".//input[@placeholder = '* Фамилия']");
    Адрес
    By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    Станция метро
    By.xpath(".//input[@placeholder = '* Станция метро']");
    Выпадашка со списком станций
    By.className("select-search__select");
    Номер телефона
    By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    Кнопка далее
    By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Далее')]");
    Предупреждашки
    By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректное имя')]");
    By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректную фамилию')]");
    By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректный адрес')]");
    By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Выберите станцию')]");
    By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректный номер')]");
     */

}
