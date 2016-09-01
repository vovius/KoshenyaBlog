<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Сконтактуй зі мною</h1>

<p>Якщо ви хочете повідомити мені щось дуже важливе про кошенят - напишіть мені :)</p>
<div class="cleaner_h50"></div>

    <div id="contact_form">

        <h2>Контактна форма</h2>

        <form method="post" name="contact" action="contactSendMail">

            <input type="hidden" name="post" value="Send" />
            <label for="author">Ім'я:</label> <input type="text" id="author" name="author" class="required input_field" />
            <div class="cleaner_h10"></div>

            <label for="email">Адреса e-mail:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
            <div class="cleaner_h10"></div>


            <label for="text">Повідомлення:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
            <div class="cleaner_h10"></div>

            <input type="submit" class="submit_btn" name="submit" id="submit" value="Надіслати" />
            <input type="reset" class="submit_btn" name="reset" id="reset" value="Скасувати" />

      </form>

    </div>
