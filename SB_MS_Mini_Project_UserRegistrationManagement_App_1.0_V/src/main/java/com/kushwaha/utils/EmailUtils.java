package com.kushwaha.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.kushwaha.domain.UserAccount;

/**
 * 
 * @author AJIT KUMAR
 * @version 1.0
 *
 */

@Component
public class EmailUtils {

	private static Logger logger = LoggerFactory.getLogger(EmailUtils.class);

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * This Method Is Used For Send Plain Text Email
	 * 
	 * @param userAccount
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean sendUserAccUnlockEmailPlainText(UserAccount userAccount) throws IOException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userAccount.getEmail());
		message.setSubject("KBM Group Registration");
		message.setText(readUserAccUnlockEmailBody(userAccount));
		javaMailSender.send(message);
		return true;
	}

	/**
	 * 
	 * @param userAccount
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean sendUserAccUnlockEmail(UserAccount userAccount) throws IOException {
		boolean isSent = false;
		try {
			MimeMessage mimeMeassage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMsgHelper = new MimeMessageHelper(mimeMeassage);
			mimeMsgHelper.setTo(userAccount.getEmail());
			mimeMsgHelper.setSubject("KBM Group Registration");
			mimeMsgHelper.setText(readUserAccUnlockEmailBody(userAccount), true);
			javaMailSender.send(mimeMeassage);
			return isSent;
		} catch (Exception e) {
			logger.debug("Exception Occured");
			return isSent;
		}
	}

	/**
	 * This Method Will Be Called For EMail Body
	 * 
	 * @param userAcc
	 * @return finalBody
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private String readUserAccUnlockEmailBody(UserAccount userAcc) throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader("USER_ACC_EMAIL_BODY_TEMPLATE.txt"))) {
			String line = br.readLine();
			StringBuilder sb = new StringBuilder("");

			while (line != null) {
				line = br.readLine();
				sb.append(line);

			}
			String finalBody = sb.toString();
			finalBody = finalBody.replaceAll("FIRST", userAcc.getFirstName());
			finalBody = finalBody.replaceAll("LAST", userAcc.getLastName());
			finalBody = finalBody.replaceAll("TEMP-PWD", userAcc.getPassword());
			finalBody = finalBody.replaceAll("EMAIL", userAcc.getEmail());
			return finalBody;
		}
	}

}
