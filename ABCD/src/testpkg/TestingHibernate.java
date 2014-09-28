package testpkg;

import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.Album;
import in.pulseinfotech.printphoto.dto.Dimension;
import in.pulseinfotech.printphoto.dto.Frame;
import in.pulseinfotech.printphoto.dto.Laminate;
import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.PaperType;
import in.pulseinfotech.printphoto.dto.Photo;
import in.pulseinfotech.printphoto.dto.Product;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.dto.UserBlockedStatus;
import in.pulseinfotech.printphoto.dto.UserStatus;
import in.pulseinfotech.printphoto.dto.payment.CardMode;
import in.pulseinfotech.printphoto.dto.payment.CashMode;
import in.pulseinfotech.printphoto.dto.payment.Note;
import in.pulseinfotech.printphoto.dto.payment.NoteValue;
import in.pulseinfotech.printphoto.dto.payment.Payment;
import in.pulseinfotech.printphoto.dto.payment.PaymentDetails;
import in.pulseinfotech.printphoto.dto.payment.PaymentMode;
import in.pulseinfotech.printphoto.dto.payment.PaymentStatus;
import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.DimensionException;
import in.pulseinfotech.printphoto.exception.EmailIDException;
import in.pulseinfotech.printphoto.exception.MobileNumberExcetion;
import in.pulseinfotech.printphoto.exception.NoteSerialNumberException;
import in.pulseinfotech.printphoto.exception.NoteValueException;
import in.pulseinfotech.printphoto.exception.PaperTypeException;
import in.pulseinfotech.printphoto.exception.PasswordException;
import in.pulseinfotech.printphoto.exception.PaymentDetailsException;
import in.pulseinfotech.printphoto.exception.PaymentModeException;
import in.pulseinfotech.printphoto.exception.PaymentStatusException;
import in.pulseinfotech.printphoto.exception.UserException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.exception.UserStateException;
import in.pulseinfotech.printphoto.exception.UserStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestingHibernate {

	User user = new User();
	Address defaultAddress = new Address();
	Product prod = new Product();
	Dimension dimension = new Dimension();
	Album album = new Album();
	Photo photo = new Photo();
	Laminate laminate = new Laminate();
	Frame frame = new Frame();
	ArrayList<Product> productList = new ArrayList<>();
	Payment payment = new Payment();
	PaymentMode paymentMode = new PaymentMode();
	Order order = new Order();
	PaymentDetails paymentDetails = new PaymentDetails();
	CashMode cashMode = new CashMode();
	CardMode cardMode = new CardMode();

	List<Note> cashDetail = new ArrayList<Note>();

	Note note1 = new Note();
	Note note2 = new Note();
	Photo photoA1 = new Photo();
	Photo photoA2 = new Photo();
	Photo photoA3 = new Photo();

	public TestingHibernate() {
		loadAddress();
		loadAlbum();
		loadCardMode();
		loadCashDetails();
		loadCashMode();
		loadDimension();
		loadNote();
		loadOrder();
		loadPayment();
		loadPaymentDetails();
		// loadPaymentMode();
		loadPhoto(photo);
		loadUser();

	}

	public void loadCardMode() {
		cardMode.setCardExpiryDate(new Date());
		cardMode.setCardNumber(865456564);
		cardMode.setTransactionId(556565656);
	}

	public void loadNote() {
		try {
			note1.setNoteValue(NoteValue.TWENTY);
		} catch (NoteValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			note1.setNoteSerialNumber("55R 839985");
		} catch (NoteValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			note2.setNoteValue(NoteValue.THOUSAND);
		} catch (NoteValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			note2.setNoteSerialNumber("5DR 039985");
		} catch (NoteValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadCashDetails() {
		cashDetail.add(note1);
		cashDetail.add(note2);
	}

	public void loadPaymentDetails() {
		paymentDetails.setPaymentAmount(1000);
		paymentDetails.setPaymentDate(new Date());
		paymentDetails.setTimeStamp(new Date());
	}

	public void loadCashMode() {
		cashMode.setCashAmount(1000);
		cashMode.setCashDetail(cashDetail);

	}

	public void loadPaymentMode() {
	}

	public void loadPayment() {
		payment.setPaymentComment("Paid In Card");
		try {
			payment.setPaymentDetails(paymentDetails);
		} catch (PaymentDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			paymentMode = cashMode;
			// paymentMode = cardMode;
			payment.setPaymentMode(paymentMode);
		} catch (PaymentModeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			payment.setPaymentStatus(PaymentStatus.PAID);
		} catch (PaymentStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadOrder() {
		try {
			order.setDeliveryAddress(defaultAddress);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setOrderComment("First Order");
		order.setPayment(payment);
		order.setProductList(productList);
		try {
			order.setUser(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Photo loadPhoto(Photo p) {
		try {
			p.setDimension(dimension);
		} catch (DimensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setFileName("Photo One");
		try {
			p.setPaperType(PaperType.METALLIC);
		} catch (PaperTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setProductComment("HARD COPY");

		return p;
	}

	public void loadAlbum() {
		ArrayList<Photo> photolist = new ArrayList<Photo>(); // setting data to

		loadPhoto(photoA1);
		photolist.add(photoA1);
		loadPhoto(photoA2);
		photolist.add(photoA2);
		loadPhoto(photoA3);
		photolist.add(photoA3);

		album.setAlbumPhotos(photolist);
		try {
			album.setDimension(dimension);
		} catch (DimensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		album.setProductComment("album");
		productList.add(album);
	}

	public void loadDimension() {

		try {
			dimension.setLength(20);
		} catch (DimensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dimension.setWidth(10);
		} catch (DimensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadUser() {

		try {
			user.setDefaultAddress(defaultAddress);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setEmailId("rimsnhnh@yahoo.com");
		} catch (EmailIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setMobileNumber(6578567890L);
		} catch (MobileNumberExcetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setName("MR. Land Lord");
		try {
			user.setPassword("aaaY38@er");
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setUserBlockedStatus(UserBlockedStatus.FREE);
		} catch (UserStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setUserComment("FIRST TO USE");

		try {
			user.setUserId(6656);
		} catch (UserIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setUserStatus(UserStatus.BEGINNER);
		} catch (UserStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadAddress() {
		defaultAddress.setCity("New York");
		defaultAddress.setLandmark("WTC");
		defaultAddress.setPin(700004);
		defaultAddress.setState("USA");
		defaultAddress.setTitle("46 park Avenue");
	}

	public void persistData() {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		s.save(user);
		s.save(cardMode);
		s.save(note1);
		s.save(note2);
		s.save(cashMode);
		prod = photo;
		s.save(prod);

		prod = photoA1;
		s.save(prod);
		prod = photoA2;
		s.save(prod);
		prod = photoA3;
		s.save(prod);
		prod = album;
		s.save(prod);
		s.save(payment);
		s.save(order);

		s.getTransaction().commit();

		s.close();
	}
}
