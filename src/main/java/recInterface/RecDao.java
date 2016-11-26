package recInterface;

import model.RecModel;

public interface RecDao {
	public RecModel getEntry(String contentId);
}
