package Jyve;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSeq;
import org.overture.codegen.runtime.VDMSet;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Menu {

	private static int state = 0;
	static Jyve jyve = new Jyve();
	
	
	// AUXILIARY FUNCTIONS
	
	private static void printArtist(Artist artist) {
		System.out.println("Stage name: " + artist.getName());
		System.out.println("Location: " + artist.getLocation().getCity() + ", " + artist.getLocation().getState());
		System.out.println("Description: " + artist.getDescription());
		if(artist.getGenres().size() > 0) {
			System.out.print("Genres: ");
			for(Iterator<String> i = artist.getGenres().iterator(); i.hasNext(); ) {
				String genre = i.next();
				System.out.println(genre + "; ");
			}
			System.out.println("\n");
		}
		if(artist.getInstruments().size() > 0) {
			System.out.print("Instruments: ");
			for(Iterator<String> i = artist.getInstruments().iterator(); i.hasNext(); ) {
					String instrument = i.next();
					System.out.println(instrument + "; ");
				}
				System.out.println("\n");
		}
		if(artist.getMusics().size() > 0) {
			System.out.print("Musics: ");
			for(Iterator<String> i = artist.getMusics().iterator(); i.hasNext(); ) {
					String music = i.next();
					System.out.println(music + "; ");
				}
				System.out.println("\n");
		}
		if(artist.getShows().size() > 0) {
			System.out.print("Shows: ");
			for(Iterator<Show> i = artist.getShows().iterator(); i.hasNext(); ) {
					Show show = i.next();
					printShow(show);
				}
				System.out.println("\n");
		}	
	}
	
	private static void printArtists(VDMSet list) {
		for(Iterator<Artist> it = list.iterator(); it.hasNext();) {
			Artist artist = it.next();
			printArtist(artist);
		}
	}
	
	private static void printBand(Band band) {
		System.out.println("Stage name: " + band.getName());
		System.out.println("Location: " + band.getLocation().getCity() + ", " + band.getLocation().getState());
		System.out.println("Description: " + band.getDescription());
		if(band.getGenres().size() > 0) {
			System.out.print("Genres: ");
			for(Iterator<String> i = band.getGenres().iterator(); i.hasNext(); ) {
				String genre = i.next();
				System.out.println(genre + "; ");
			}
			System.out.println("\n");
		}
		if(band.getMembers().size() > 0) {
			System.out.print("Members: ");
			for(Iterator<Artist> i = band.getMembers().iterator(); i.hasNext(); ) {
					Artist art = i.next();
					System.out.println(art.getName() + "; ");
				}
				System.out.println("\n");
		}
		if(band.getMusics().size() > 0) {
			System.out.print("Musics: ");
			for(Iterator<String> i = band.getMusics().iterator(); i.hasNext(); ) {
					String music = i.next();
					System.out.println(music + "; ");
				}
				System.out.println("\n");
		}
		if(band.getShows().size() > 0) {
			System.out.print("Shows: ");
			for(Iterator<Show> i = band.getShows().iterator(); i.hasNext(); ) {
					Show show = i.next();
					printShow(show);
				}
				System.out.println("\n");
		}
		
	}
	
	private static void printBands(VDMSet list) {
		for(Iterator<Band> it = list.iterator(); it.hasNext();) {
			Band band = it.next();
			printBand(band);
		}
	}
	
	private static void printVenue(Venue venue) {
		System.out.println("Name: " + venue.getName());
		System.out.println("Location: " + venue.getLocation().getCity() + ", " + venue.getLocation().getState());
		System.out.println("Description: " + venue.getDescription());
		if(venue.getShows().size() > 0) {
			System.out.print("Shows: ");
			for(Iterator<Show> i = venue.getShows().iterator(); i.hasNext(); ) {
					Show show = i.next();
					printShow(show);
				}
			System.out.println("\n");
		}
	}
	
	private static void printVenues(VDMSet list) {
		for(Iterator<Venue> it = list.iterator(); it.hasNext();) {
			Venue venue = it.next();
			printVenue(venue);
		}
	}
	
	private static void printShow(Show show) {
		System.out.println(jyve.getArtBandbyShow(show) + " at " + show.getVenue().getName() + " on " + show.getStartDate().getDay() + "/" + show.getStartDate().getMonth() + "/" + show.getStartDate().getYear() + " " 
				+ show.getStartDate().getHour() + ":" + show.getStartDate().getMinutes() + " - " + show.getDescription() + ";");
	}
	
	private static void printShows(VDMSet list) {
		for(Iterator<Show> it = list.iterator(); it.hasNext();) {
			Show show = it.next();
			printShow(show);
		}
	}
	
	private static String usingStringMenu() {
		Scanner scanner = new Scanner(System.in);
		String readString = scanner.nextLine();
		while (readString.isEmpty() && readString != null)
			if(scanner.hasNextLine()) {
				readString = scanner.nextLine();
			} else {
				readString = null;
			}
		return readString;
	}
	
	// MENUS
	
	private static void mainMenu() {
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter: ");
		System.out.println("1. Artists");
		System.out.println("2. Bands");
		System.out.println("3. Venues");
		System.out.println("4. Shows");
		System.out.println("5. Search for an artist");
		System.out.println("6. Search for a band");
		System.out.println("7. Search for a venue");
		System.out.println("8. Search for a show");
		System.out.println("0. Exit the application");
	}
	
	private static void artistsMenu() {
		Scanner scan = new Scanner(System.in);		
			
		if(jyve.getArtists().size() > 0) {
			System.out.println("The Jyve application currently has the following artists: ");
			printArtists(jyve.getArtists());
		}
		else {
			System.out.println("The application doesn't have any artists yet :(");
		}
	
		System.out.println("1. Access an artist's menu");
		System.out.println("2. Create and add an artist");
		System.out.println("0. Return to main menu");
		
		int tempState = scan.nextInt();
	
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the name of the artist to access the menu from followed by Enter: ");
				String aname = usingStringMenu();
				artistMenu(jyve.getArtistbyName(aname));
				break;
			case 2:
				System.out.println("Insert the stage name of the new artist followed by Enter: ");
				String stagename = usingStringMenu();
				System.out.println("Insert the name of the city of the new artist followed by Enter: ");
				String city = usingStringMenu();
				System.out.println("Insert the name of the state of the new artist followed by Enter: ");
				String state = usingStringMenu();
				Location l = new Location(city, state);
				VDMSet genres = new VDMSet();
				VDMSet instruments = new VDMSet();
				Artist art = new Artist(stagename, l, " ", genres, instruments);
				jyve.addArtist(art);
				artistMenu(art);
				break;
		}
	}
	
	private static void artistMenu(Artist art) {
		Scanner scan = new Scanner(System.in);
		String artname = art.getName();

		System.out.println("Information stored about " + artname + ":");
		printArtist(art);
	
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter: ");
		System.out.println("1. Add music");
		System.out.println("2. Remove music");
		System.out.println("3. Add genre");
		System.out.println("4. Remove genre");
		System.out.println("5. Add instrument");
		System.out.println("6. Remove instrument");
		System.out.println("7. Edit description");
		System.out.println("8. Edit stage name");
		System.out.println("9. Edit location");
		System.out.println("10. Schedule a show");
		System.out.println("11. Cancel a show");
		System.out.println("12. Edit a show description");
		System.out.println("13. Create and add band");
		System.out.println("0. Back to main menu");
		
		int tempState = scan.nextInt();
	
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the name of the music to be added to artist: " + artname);
				String mnameadd = usingStringMenu();
				art.addMusic(mnameadd);
				System.out.println("Music successfully added!");					
				artistMenu(art);
				break;
			case 2:
				System.out.println("Insert the name of the music to be removed from artist: " + artname);
				String mnamerem = usingStringMenu();
				art.removeMusic(mnamerem);
				System.out.println("Music successfully removed!");
				artistMenu(art);
				break;
			case 3:
				System.out.println("Insert the name of the genre to be added to artist: " + artname);
				String genreadd = usingStringMenu();
				art.addGenre(genreadd);
				System.out.println("Genre successfully added!");
				artistMenu(art);
				break;
			case 4:
				System.out.println("Insert the name of the genre to be removed from artist: " + artname);
				String genrerem = usingStringMenu();
				art.removeGenre(genrerem);
				System.out.println("Genre successfully removed!");
				artistMenu(art);
				break;
			case 5:
				System.out.println("Insert the name of the instrument to be added to artist: " + artname);
				String instadd = usingStringMenu();
				art.addInstrument(instadd);
				System.out.println("Instrument successfully added!");
				artistMenu(art);
				break;
			case 6:
				System.out.println("Insert the name of the instrument to be removed from artist: " + artname);
				String instrem = usingStringMenu();
				art.removeInstrument(instrem);
				System.out.println("Instrument successfully removed!");
				artistMenu(art);
				break;
			case 7:
				System.out.println("Insert the description to be edited from artist: " + artname);
				String descedit = usingStringMenu();
				art.setDescription(descedit);
				System.out.println("Description successfully edited!");
				artistMenu(art);
				break;
			case 8:
				System.out.println("Insert the stage name to be edited from artist: " + artname);
				String snameedit = usingStringMenu();
				art.setName(snameedit);;
				System.out.println("Name successfully edited!");
				artistMenu(art);
				break;
			case 9:
				System.out.println("Insert the name of the city to be edited from artist: " + artname);
				String cityedit = usingStringMenu();
				System.out.println("Insert the name of the state to be edited from artist: " + artname);
				String stateedit = usingStringMenu();
				Location l = new Location(cityedit, stateedit);
				art.setLocation(l);
				System.out.println("Location successfully edited!");
				artistMenu(art);
				break;
			case 10:
				printVenues(jyve.getVenues());
				System.out.println("Insert the name of the venue where the show will take place: ");
				String vname = usingStringMenu();
				System.out.println("Insert the year of the start date for when the show will take place: ");
				String ystart = usingStringMenu();
				System.out.println("Insert the month of the start date for when the show will take place: ");
				String monstart = usingStringMenu();
				System.out.println("Insert the day of the start date for when the show will take place: ");
				String dstart = usingStringMenu();
				System.out.println("Insert the hour of the start date for when the show will take place: ");
				String hstart = usingStringMenu();
				System.out.println("Insert the minutes of the start date for when the show will take place: ");
				String minstart = usingStringMenu();
				System.out.println("Insert the year of the end date for when the show will take place: ");
				String yend = usingStringMenu();
				System.out.println("Insert the month of the end date for when the show will take place: ");
				String monend = usingStringMenu();
				System.out.println("Insert the day of the end date for when the show will take place: ");
				String dend = usingStringMenu();
				System.out.println("Insert the hour of the end date for when the show will take place: ");
				String hend = usingStringMenu();
				System.out.println("Insert the minutes of the end date for when the show will take place: ");
				String minend = usingStringMenu();
				System.out.println("Insert a brief description for the show that will take place: ");
				String descrip = usingStringMenu();
				DateTime stime = new DateTime(Integer.parseInt(ystart), Integer.parseInt(monstart), Integer.parseInt(dstart), 
						Integer.parseInt(hstart), Integer.parseInt(minstart));
				DateTime etime = new DateTime(Integer.parseInt(yend), Integer.parseInt(monend), Integer.parseInt(dend), 
						Integer.parseInt(hend), Integer.parseInt(minend));
				Show nshow = new Show(stime, etime, jyve.getVenuebyName(vname), descrip);
				art.addShow(nshow);
				System.out.println("Show successfully added!");
				artistMenu(art);
				break;
			case 11:
				printShows(art.getShows());
				System.out.println("Insert the name of the venue where the show to be canceled would take place: ");
				String vencancel = usingStringMenu();
				System.out.println("Insert the year of the show to to be canceled: ");
				String ycancel = usingStringMenu();
				System.out.println("Insert the month of the show to be canceled: ");
				String moncancel = usingStringMenu();
				System.out.println("Insert the day of the show to be canceled: ");
				String dcancel = usingStringMenu();
				System.out.println("Insert the start hour of the show to be canceled: ");
				String hcancel = usingStringMenu();
				System.out.println("Insert the starting minutes of the show to be canceled: ");
				String mincancel = usingStringMenu();
				Show cshow = art.getShow(vencancel, Integer.parseInt(ycancel), Integer.parseInt(moncancel), Integer.parseInt(dcancel), 
						Integer.parseInt(hcancel), Integer.parseInt(mincancel));
				art.removeShow(cshow);
				System.out.println("Show successfully canceled!");
				artistMenu(art);
				break;
			case 12:
				printShows(art.getShows());
				System.out.println("Insert the name of the venue where the show to be edited would take place: ");
				String venedit = usingStringMenu();
				System.out.println("Insert the year of the show to to be edited: ");
				String yedit = usingStringMenu();
				System.out.println("Insert the month of the show to be edited: ");
				String monedit = usingStringMenu();
				System.out.println("Insert the day of the show to be edited: ");
				String dedit = usingStringMenu();
				System.out.println("Insert the start hour of the show to be edited: ");
				String hedit = usingStringMenu();
				System.out.println("Insert the starting minutes of the show to be edited: ");
				String minedit = usingStringMenu();
				System.out.println("Insert the new description for the show: ");
				String descedite = usingStringMenu();
				Show cshowe = art.getShow(venedit, Integer.parseInt(yedit), Integer.parseInt(monedit), Integer.parseInt(dedit), 
						Integer.parseInt(hedit), Integer.parseInt(minedit));
				cshowe.setDescription(descedite);
				System.out.println("Show description successfully edited!");
				artistMenu(art);
				break;
			
			case 13:
				System.out.println("Insert the name of the new band followed by Enter: ");
				String bname = usingStringMenu();
				System.out.println("Insert the name of the city of the new band followed by Enter: ");
				String bcity = usingStringMenu();
				System.out.println("Insert the name of the state of the new band followed by Enter: ");
				String bstate = usingStringMenu();
				Location lb = new Location(bcity, bstate);
				VDMSet bgenres = new VDMSet();
				VDMSet bmembers = new VDMSet();
				bmembers.add(art);
				Band band = new Band(bname, lb, " ", bgenres, bmembers);
				jyve.addBand(band);
				bandMenu(band);
				break;			
			}
	}
	
	private static void bandsMenu() {
		Scanner scan = new Scanner(System.in);
		
		if(jyve.getBands().size() > 0) {
			System.out.println("The Jyve application currently has the following bands: ");
			printBands(jyve.getBands());
		}
		else {
			System.out.println("The application doesn't have any bands yet :(");
		}
	
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter;");
		System.out.println("1. Access a band's menu");
		System.out.println("0. Return to main menu");
		
		int tempState = scan.nextInt();
	
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the name of the band to access the menu from followed by Enter: ");
				String bname = usingStringMenu();
				bandMenu(jyve.getBandbyName(bname));
				break;
			}
	}
	
	private static void bandMenu(Band band) {
		Scanner scan = new Scanner(System.in);
		String bandname = band.getName();		
			
		System.out.println("Information stored about " + bandname + ":");
		printBand(band);
			
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter: ");
		System.out.println("1. Add music");
		System.out.println("2. Remove music");
		System.out.println("3. Add genre");
		System.out.println("4. Remove genre");
		System.out.println("5. Add member");
		System.out.println("6. Remove member");
		System.out.println("7. Edit description");
		System.out.println("8. Edit stage name");
		System.out.println("9. Edit location");
		System.out.println("10. Schedule a show");
		System.out.println("11. Cancel a show");
		System.out.println("12. Edit a show description");
		System.out.println("0. Back to main menu");
			
		int tempState = scan.nextInt();
			
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the name of the music to be added to band " + bandname + ":");
				String mnameadd = usingStringMenu();
				band.addMusic(mnameadd);
				System.out.println("Music successfully added!");					
				bandMenu(band);
				break;
			case 2:
				System.out.println("Insert the name of the music to be removed from band " + bandname + ":");
				String mnamerem = usingStringMenu();
				band.removeMusic(mnamerem);
				System.out.println("Music successfully removed!");
				bandMenu(band);
				break;
			case 3:
				System.out.println("Insert the name of the genre to be added to band " + bandname + ":");
				String genreadd = usingStringMenu();
				band.addGenre(genreadd);
				System.out.println("Genre successfully added!");
				bandMenu(band);
				break;
			case 4:
				System.out.println("Insert the name of the genre to be removed from band " + bandname + ":");
				String genrerem = usingStringMenu();
				band.removeGenre(genrerem);
				System.out.println("Genre successfully removed!");
				bandMenu(band);
				break;
			case 5:
				printArtists(jyve.getArtists());
				System.out.println("Insert the name of the artist to be added to band " + bandname + ":");
				String memadd = usingStringMenu();
				band.addMember(jyve.getArtistbyName(memadd));
				System.out.println("Member successfully added!");
				bandMenu(band);
				break;
			case 6:
				printArtists(band.getMembers());
				System.out.println("Insert the name of the member to be removed from band " + bandname + ":");
				String memrem = usingStringMenu();
				band.removeMember(jyve.getArtistbyName(memrem));
				System.out.println("Member successfully removed!");
				bandMenu(band);
				break;
			case 7:
				System.out.println("Insert the description to be edited from band " + bandname + ":");
				String descedit = usingStringMenu();
				band.setDescription(descedit);
				System.out.println("Description successfully edited!");
				bandMenu(band);
				break;
			case 8:
				System.out.println("Insert the name to be edited from band " + bandname + ":");
				String snameedit = usingStringMenu();
				band.setName(snameedit);;
				System.out.println("Name successfully edited!");
				bandMenu(band);
				break;
			case 9:
				System.out.println("Insert the name of the city to be edited from band " + bandname + ":");
				String cityedit = usingStringMenu();
				System.out.println("Insert the name of the state to be edited from band " + bandname + ":");
				String stateedit = usingStringMenu();
				Location l = new Location(cityedit, stateedit);
				band.setLocation(l);
				System.out.println("Location successfully edited!");
				bandMenu(band);
				break;
			case 10:
				printVenues(jyve.getVenues());
				System.out.println("Insert the name of the venue where the show will take place: ");
				String vname = usingStringMenu();
				System.out.println("Insert the year of the start date for when the show will take place: ");
				String ystart = usingStringMenu();
				System.out.println("Insert the month of the start date for when the show will take place: ");
				String monstart = usingStringMenu();
				System.out.println("Insert the day of the start date for when the show will take place: ");
				String dstart = usingStringMenu();
				System.out.println("Insert the hour of the start date for when the show will take place: ");
				String hstart = usingStringMenu();
				System.out.println("Insert the minutes of the start date for when the show will take place: ");
				String minstart = usingStringMenu();
				System.out.println("Insert the year of the end date for when the show will take place: ");
				String yend = usingStringMenu();
				System.out.println("Insert the month of the end date for when the show will take place: ");
				String monend = usingStringMenu();
				System.out.println("Insert the day of the end date for when the show will take place: ");
				String dend = usingStringMenu();
				System.out.println("Insert the hour of the end date for when the show will take place: ");
				String hend = usingStringMenu();
				System.out.println("Insert the minutes of the end date for when the show will take place: ");
				String minend = usingStringMenu();
				System.out.println("Insert a brief description for the show that will take place: ");
				String descrip = usingStringMenu();
				DateTime stime = new DateTime(Integer.parseInt(ystart), Integer.parseInt(monstart), Integer.parseInt(dstart), 
						Integer.parseInt(hstart), Integer.parseInt(minstart));
				DateTime etime = new DateTime(Integer.parseInt(yend), Integer.parseInt(monend), Integer.parseInt(dend), 
						Integer.parseInt(hend), Integer.parseInt(minend));
				Show nshow = new Show(stime, etime, jyve.getVenuebyName(vname), descrip);
				band.addShow(nshow);
				System.out.println("Show successfully added!");
				bandMenu(band);
				break;
			case 11:
				printShows(band.getShows());
				System.out.println("Insert the name of the venue where the show to be canceled would take place: ");
				String vencancel = usingStringMenu();
				System.out.println("Insert the year of the show to to be canceled: ");
				String ycancel = usingStringMenu();
				System.out.println("Insert the month of the show to be canceled: ");
				String moncancel = usingStringMenu();
				System.out.println("Insert the day of the show to be canceled: ");
				String dcancel = usingStringMenu();
				System.out.println("Insert the start hour of the show to be canceled: ");
				String hcancel = usingStringMenu();
				System.out.println("Insert the starting minutes of the show to be canceled: ");
				String mincancel = usingStringMenu();
				Show cshow = band.getShow(vencancel, Integer.parseInt(ycancel), Integer.parseInt(moncancel), Integer.parseInt(dcancel), 
						Integer.parseInt(hcancel), Integer.parseInt(mincancel));
				band.removeShow(cshow);
				System.out.println("Show successfully canceled!");
				bandMenu(band);
				break;
			case 12:
				printShows(band.getShows());
				System.out.println("Insert the name of the venue where the show to be edited would take place: ");
				String venedit = usingStringMenu();
				System.out.println("Insert the year of the show to to be edited: ");
				String yedit = usingStringMenu();
				System.out.println("Insert the month of the show to be edited: ");
				String monedit = usingStringMenu();
				System.out.println("Insert the day of the show to be edited: ");
				String dedit = usingStringMenu();
				System.out.println("Insert the start hour of the show to be edited: ");
				String hedit = usingStringMenu();
				System.out.println("Insert the starting minutes of the show to be edited: ");
				String minedit = usingStringMenu();
				System.out.println("Insert the new description for the show: ");
				String descedits = usingStringMenu();
				Show cshowedit = band.getShow(venedit, Integer.parseInt(yedit), Integer.parseInt(monedit), Integer.parseInt(dedit), 
						Integer.parseInt(hedit), Integer.parseInt(minedit));
				cshowedit.setDescription(descedits);
				System.out.println("Show description successfully edited!");
				bandMenu(band);
				break;
			}
	}
	
	private static void venuesMenu() {
		Scanner scan = new Scanner(System.in);
					
		if(jyve.getVenues().size() > 0) {
			System.out.println("The Jyve application currently has the following venues: ");
			printVenues(jyve.getVenues());
		}
		else {
			System.out.println("The application doesn't have any venues yet :(");
		}
	
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter:");
		System.out.println("1. Access a venue's menu");
		System.out.println("2. Creat and add a venue");
		System.out.println("0. Return to main menu");
		
		int tempState = scan.nextInt();
	
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the name of the venue to access the menu from followed by Enter: ");
				String vname = usingStringMenu();
				venueMenu(jyve.getVenuebyName(vname));
				break;
			case 2:
				System.out.println("Insert the name of the new venue followed by Enter: ");
				String vnameadd = usingStringMenu();
				System.out.println("Insert the name of the city of the new venue followed by Enter: ");
				String vcity = usingStringMenu();
				System.out.println("Insert the name of the state of the new venue followed by Enter: ");
				String vstate = usingStringMenu();
				Location l = new Location(vcity, vstate);
				Venue venue = new Venue(vnameadd, l, " ");
				jyve.addVenue(venue);
				venueMenu(venue);
				break;
			}
	}
	
	private static void venueMenu(Venue venue) {
		Scanner scan = new Scanner(System.in);
		String venuename = venue.getName();
		
		System.out.println("Information stored about " + venue.getName() + ":");
		printVenue(venue);
		
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter: ");
		System.out.println("1. Edit description");
		System.out.println("2. Edit venue name");
		System.out.println("3. Edit location");
		System.out.println("4. Cancel a show");
		System.out.println("0. Back to main menu");
		
		int tempState = scan.nextInt();
		
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			case 1:
				System.out.println("Insert the description to be edited from venue " + venuename + ":");
				String descedit = usingStringMenu();
				venue.setDescription(descedit);
				System.out.println("Description successfully edited!");
				venueMenu(venue);
				break;
			case 2:
				System.out.println("Insert the name to be edited from venue " + venuename + ":");
				String snameedit = usingStringMenu();
				venue.setName(snameedit);
				System.out.println("Name successfully edited!");
				venueMenu(venue);
				break;
			case 3:
				System.out.println("Insert the name of the city to be edited from venue " + venuename + ":");
				String cityedit = usingStringMenu();
				System.out.println("Insert the name of the state to be edited from venue " + venuename + ":");
				String stateedit = usingStringMenu();
				Location l = new Location(cityedit, stateedit);
				venue.setLocation(l);
				System.out.println("Location successfully edited!");
				venueMenu(venue);
				break;
			case 4:
				printShows(venue.getShows());
				System.out.println("Insert the name of the artist or band to cancel the show of: ");
				String artorbcancel = usingStringMenu();
				System.out.println("Insert the year of the show to to be canceled: ");
				String ycancel = usingStringMenu();
				System.out.println("Insert the month of the show to be canceled: ");
				String moncancel = usingStringMenu();
				System.out.println("Insert the day of the show to be canceled: ");
				String dcancel = usingStringMenu();
				System.out.println("Insert the start hour of the show to be canceled: ");
				String hcancel = usingStringMenu();
				System.out.println("Insert the starting minutes of the show to be canceled: ");
				String mincancel = usingStringMenu();
				if(jyve.getArtistbyName(artorbcancel) == null) {
					Show scancelb = jyve.getBandbyName(artorbcancel).getShow(venue.getName(), Integer.parseInt(ycancel), 
							Integer.parseInt(moncancel), Integer.parseInt(dcancel), Integer.parseInt(hcancel), Integer.parseInt(mincancel));
					venue.cancelShow(scancelb, jyve);
				}
				else
				{
					Show scancela = jyve.getArtistbyName(artorbcancel).getShow(venue.getName(), Integer.parseInt(ycancel), 
							Integer.parseInt(moncancel), Integer.parseInt(dcancel), Integer.parseInt(hcancel), Integer.parseInt(mincancel));
					venue.cancelShow(scancela, jyve);
				}
				System.out.println("Show successfully canceled!");
				venueMenu(venue);
				break;
			}	
	}
	
	private static void showsMenu() {
		Scanner scan = new Scanner(System.in);
					
		if(jyve.getVenues().size() > 0) {
			for(Iterator<Venue> it = jyve.getVenues().iterator(); it.hasNext();) {
				Venue venue = it.next();
				if(venue.getShows().size() > 0) {
					for(Iterator<Show> its = venue.getShows().iterator(); its.hasNext();) {
						Show show = its.next();
						printShow(show);
					}
				}
				else {
					System.out.println("Looks like venue " + venue.getName() + " doesn't have any shows scheduled yet...");
				}
			}
		}
		else {
			System.out.println("The application doesn't have any venues and, thus, no shows yet :(");
		}
		
		System.out.println("To continue please insert the number corresponding to the menu option followed by Enter:");
		System.out.println("Average number of shows per artist/band on Jyve: " + jyve.avgShowPerArtistBand());
		System.out.println("0. Return to main menu");
		
		int tempState = scan.nextInt();
	
		switch(tempState) {
			case 0:
				tempState = -1;
				break;
			}
	}
	
	public static void main(String[] arg) {
	
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Welcome to Jyve!");
		
		while(state != -1) {
			mainMenu();
			
			state = scan.nextInt();
		
			switch(state) {
				case 0:
					state = -1;
					break;
				case 1:
					artistsMenu();
					break;
				case 2:
					bandsMenu();
					break;
				case 3:
					venuesMenu();
					break;
				case 4:
					showsMenu();
					break;
				case 5:
					System.out.println("Insert the name or description of the artist to search: ");
					String anamedes = usingStringMenu();
					VDMSet ares = jyve.searchArtist(anamedes);
					if(ares.size() > 0) {
						for(Iterator<Artist> it = ares.iterator(); it.hasNext(); ) {
							printArtist(it.next());
						}
					}
					else {
						System.out.println("Sorry, no results were found...");
					}
					break;
				case 6:
					System.out.println("Insert the name or description of the band to search: ");
					String bnamedes = usingStringMenu();
					VDMSet bres = jyve.searchBand(bnamedes);
					if(bres.size() > 0) {
						System.out.println("The results found were the following: ");
						for(Iterator<Band> it = bres.iterator(); it.hasNext(); ) {
							printBand(it.next());
						}
					}
					else {
						System.out.println("Sorry, no results were found...");
					}
					break;
				case 7:
					System.out.println("Insert the name or description of the venue to search: ");
					String vnamedes = usingStringMenu();
					VDMSet vres = jyve.searchVenue(vnamedes);
					if(vres.size() > 0) {
						System.out.println("The results found were the following: ");
						for(Iterator<Venue> it = vres.iterator(); it.hasNext(); ) {
							printVenue(it.next());
						}
					}
					else {
						System.out.println("Sorry, no results were found...");
					}
					break;
				case 8:
					System.out.println("Insert the description of the show to search: ");
					String sdes = usingStringMenu();
					VDMSet sres = jyve.searchShow(sdes);
					if(sres.size() > 0) {
						System.out.println("The results found were the following: ");
						for(Iterator<Show> it = sres.iterator(); it.hasNext(); ) {
							printShow(it.next());
						}
					}
					else {
						System.out.println("Sorry, no results were found...");
					}
					break;
			}
		}
	}
}