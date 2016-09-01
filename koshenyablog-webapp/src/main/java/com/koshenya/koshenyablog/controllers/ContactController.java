package com.koshenya.koshenyablog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * Created by sony on 8/28/2016.
 */
@Controller
@RequestMapping("/blogContact")
public class ContactController {

    @RequestMapping("/")
    public ModelAndView getContactView() {
        ModelAndView view = new ModelAndView("blogContact");
        return view;
    }

    @RequestMapping("contactSendMail")
    public ModelAndView contactSendMail(
            @RequestParam(name = "author") String author,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "text") String text
    ) throws Exception {
        Properties connProps = new Properties();
        connProps.load(getClass().getClassLoader().getResourceAsStream("mailconnect.properties"));

        Properties sendProperties = new Properties();
        sendProperties.load(getClass().getClassLoader().getResourceAsStream("mailsend.properties"));
        final String user = sendProperties.getProperty("username");
        final String pass = sendProperties.getProperty("password");
        Session session = Session.getInstance(connProps,
                new Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(user, pass);
                    }
                });

        if (session != null) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendProperties.getProperty("to")));
            message.setSubject(String.format(sendProperties.getProperty("topic"), author));
            message.setText(text);

            boolean result = sendEmailFuture(message);
        }

        return getContactView();
    }

    private boolean sendEmailFuture(Message message) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executorService.submit((Callable<Boolean>)()->{
            try {
                Transport.send(message);
                return true;
            } catch (MessagingException e) {
                e.printStackTrace();
                executorService.shutdown();
                return false;
            }
        });

        try {
            Boolean result = future.get();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            executorService.shutdown();
        }
    }
}
