/**
 *
 */
package com.koweg.poc.payments.rest.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koweg.poc.payments.rest.exception.PaymentNotFoundException;
import com.koweg.poc.payments.rest.representation.Payment;

/**
 * @author olarinde.ajai@gmail.com
 *
 */
@Controller
@RequestMapping("/payment")
public class PaymentAccountResourceImpl {
  private static Map<Long, Payment> paymentList;
  private static AtomicLong paymentId = new AtomicLong(0);

  static {
    paymentList = new ConcurrentHashMap<Long, Payment>();
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("700370.50"), DateTime.now().toDate(), "USD"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("43.3"), DateTime.now().toDate(), "EUR"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("79.7"), DateTime.now().toDate(), "EUR"));
    paymentList.put(paymentId.incrementAndGet(),
        new Payment(paymentId.get(), new BigDecimal("89.7"), DateTime.now().toDate(), "EUR"));
  }

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    sdf.setLenient(true);
    dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }

  @RequestMapping(value = "/history", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseBody
  public List<Payment> getPayments() {
    return Collections.list(Collections.enumeration(paymentList.values()));
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
      MediaType.TEXT_XML_VALUE })
  @ResponseBody
  public Payment getPayment(@PathVariable Long id) {
    return paymentList.get(id);
  }

  @RequestMapping(value = "/authorize", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
      MediaType.APPLICATION_JSON_VALUE })
  @ResponseBody
  public ResponseEntity<Void> makePayment(@Valid @RequestBody Payment payment) {
    long id = paymentId.incrementAndGet();
    payment.setId(id);
    payment.setDate(DateTime.now().toDate());
    paymentList.put(id, payment);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(linkTo(PaymentAccountResourceImpl.class).slash(id).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/cancel/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public void cancelPayment(@PathVariable("id") Long id) throws PaymentNotFoundException {
    if (paymentList.get(id) == null) {
      throw new PaymentNotFoundException(id);
    }
    paymentList.remove(id);
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
      MediaType.TEXT_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
  @ResponseBody
  public void updatePayment(@Valid @RequestBody Payment update) {
    paymentList.put(update.getId(), update);
  }

  @ExceptionHandler({ PaymentNotFoundException.class })
  protected ResponseEntity<String> notFoundExceptionHandler(Exception ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);

  }

}
