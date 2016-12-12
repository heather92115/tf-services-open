package com.tf.ws.model;

public enum FileSizeRange {

	LESS_THAN_100KB("fileSizeRange.lessThan100KB", 0, 100 * 1024 - 1),
	BETWEEN_100KB_AND_500KB("fileSizeRange.between100KBAnd500KB", 100 * 1024, 500 * 1024 - 1),
	BETWEEN_500KB_AND_1MB("fileSizeRange.between500KBAnd1MB", 500 * 1024, 1024 * 1024 - 1),
	BETWEEN_1MB_AND_5MB("fileSizeRange.between1MBAnd5MB", 1024 * 1024, 5 * 1024 * 1024 - 1),
	ABOVE_5MB("fileSizeRange.above5MB", -1, -1); // chosen by default.

	private String label; // Used with resource bundle.
	private long fromSize;
	private long toSize;

	FileSizeRange(String label, long fromSize, long toSize) {
		this.label = label;
		this.fromSize = fromSize;
		this.toSize = toSize;
	}

	public String getLabel() {
		return this.label;
	}

	/**
	 * Returns matching enum for given file size.
	 *
	 * @param fileSize      File size to consider.
	 * @return              Enum containing file size within its range.
	 */
	public static FileSizeRange getEnumForFileSize(long fileSize) {

		for (FileSizeRange fileSizeRange: FileSizeRange.values()) {
			if (fileSize >= fileSizeRange.fromSize && fileSize <= fileSizeRange.toSize) {
				return fileSizeRange;
			}
		}

		return ABOVE_5MB;
	}
}
