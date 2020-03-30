import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MockNotesStorage implements NotesStorage {
	private ArrayList<Note> notes;
	
	public MockNotesStorage() {
		clear();
	}
	
	public void add(Note note) {
		this.notes.add(note);
	}
	
	public List<Note> getAllNotesOf(String name) {
		ArrayList<Note> out = new ArrayList<Note>();
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getName() == name) {
				out.add(notes.get(i));
			}
		}
		return out;
	}
	
	public void clear() {
		notes = new ArrayList<Note>();
	}
}

class NotesServiceImplTest {
	
	NotesServiceImpl ns;
	
	@BeforeEach
	void setup() {
		
	}
	
	@Test
	void test_NotesService_createWith() {
		
	}
	
	@Test
	void test_NotesService_add() {
		
	}
	
	@Test
	void test_NotesService_averageOf() {
		
	}
	
	@Test
	void test_NotesService_clear() {
		
	}
}
