package assignment;

import javax.swing.JOptionPane;

public class Validate {
	@SuppressWarnings("static-access")
	public static boolean checkCode(String code) {
		String reCode = "[N]{1}[V]{1}[0-9]{5}";
		if (code.isBlank()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống mã nhân viên!");
			return false;
		} else if (!code.matches(reCode)) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập đúng mã nhân viên NV12345!");
			return false;
		} else {
			boolean check = true;
			StaffList list = new StaffList();
			for (int i = 0; i < list.listStaffs.size(); i++) {
				if (list.listStaffs.get(i).getCode().equalsIgnoreCase(code)) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại!");
					System.out.println("false");
					check = false;
					break;
				}
			}
			return check;
		}
	}
	
	@SuppressWarnings("static-access")
	public boolean checkCodeUpdate(String code, int row) {
		code = code.trim().toUpperCase();
		String reCode = "[N]{1}[V]{1}[0-9]{5}";
		if (code.length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống mã nhân viên!");
			return false;
		} else if (!code.matches(reCode)) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập đúng mã nhân viên NV12345!");
			return false;
		} else {
			boolean check = true;
			StaffList list = new StaffList();
			for (int i = 0; i < list.listStaffs.size(); i++) {
				if(i == row || row == 0) {
					continue;
				} else
				if (list.listStaffs.get(i).getCode().equalsIgnoreCase(code)) {
					JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại!");
					System.out.println("false");
					check = false;
					break;
				}
			}
			return check;
		}
	}

	public static boolean checkName(String name) {
		if (name.trim().length() <= 0) {
			JOptionPane.showInternalMessageDialog(null, "Bạn không được để trống tên!");
			return false;
		} else
			return true;
	}

	public static boolean checkAge(String age) {
		try {
			int tuoi = Integer.parseInt(age);
			if (tuoi < 16 || tuoi > 55) {
				JOptionPane.showMessageDialog(null, "Nhân viên tuổi phải từ 16 đến 55!");
				return false;
			} else
				return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập đúng định dạng tuổi!");
			return false;
			// TODO: handle exception
		}
	}

	public static boolean checkEmail(String email) {
		String reEmail = "\\w+@\\w+\\.\\w+";
		if (!email.matches(reEmail)) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập đúng định dạng email!");
			return false;
		} else
			return true;
	}

	public static boolean checkSalary(String salary) {
		try {
			if (salary.trim().length() <= 0) {
				JOptionPane.showMessageDialog(null, "Bạn không được để trống lương!");
				return false;
			} else {
				double luong = Double.parseDouble(salary);
				if (luong < 5000000) {
					JOptionPane.showMessageDialog(null, "Lương phải lớn hơn 5,000,000!");
					return false;
				} else
					return true;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn nhập sai định dạng lương!");
			return false;
			// TODO: handle exception
		}
	}
 
}
