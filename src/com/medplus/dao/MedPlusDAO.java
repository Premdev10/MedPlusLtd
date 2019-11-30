package com.medplus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.medplus.bean.MedPlusBean;
import com.medplus.bean.SignUpBean;


public class MedPlusDAO {
	private static Connection con=null;
	 private static PreparedStatement pst=null;
  private static ResultSet rs=null;
  private static int i=0;
  private static double percentage=0;
  private static int newQuantity;
  static Date date;
  String key;
  
	 private static int flag=0;

		public static Connection getDbConnection()throws SQLException {
			
			try{
				DBDAO.dbConnection();
				con=DBDAO.getDbCon();
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return con;
		}
	 
	 
	public static int check(MedPlusBean medplus)throws SQLException{
		  
		   try{
			  
	        con=getDbConnection();
	        pst=con.prepareStatement("select l_role from tbl_logintable where l_name=? and l_password=? ");
			pst.setString(1, medplus.getUname());
			
			pst.setString(2, medplus.getPassword());
			rs=pst.executeQuery();
		
				while(rs.next()){
				String role=rs.getString("l_role");
				System.out.println(role);
					if(role.equalsIgnoreCase("admin")){
						flag=1;
					}
					else if(role.equalsIgnoreCase("user")){
						flag=2;
					}
					else if(role.equalsIgnoreCase("doctor")){
						flag=3;
					}
					else if(role.equalsIgnoreCase("storekeeper")){
						flag=4;
					}
				}
			
		   }
		  catch(Exception e){
			  e.printStackTrace();
		  }
		   return flag;
	   
	   }

	 public static int  getUserId(MedPlusBean medplus) throws SQLException{
		 
	 
	    	
	    	
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select reg_id from tbl_logintable where l_name='"+medplus.getUname()+"'and l_password='"+medplus.getPassword()+"'");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	
	        	i=rs.getInt(1);
		}
	}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print(i);
		return i;
		
	}
		public static int insertMedicine(MedPlusBean medplus) throws SQLException{
			 
			  try{
				  con=getDbConnection();
				  pst=con.prepareStatement("insert into tbl_medicine(m_medname,m_time,m_quantity,reg_id,m_newquantity) values(?,?,?,?,?)");
				  pst.setString(1, medplus.getMedicinename());
				  pst.setString(2,medplus.getTime());
				  pst.setInt(3, medplus.getQuantity());
				  pst.setInt(4, medplus.getId());
				  pst.setInt(5, medplus.getQuantity());
				 
				  i=pst.executeUpdate();
				  
			  }catch(Exception e){
				  e.printStackTrace();
			  }
			  return i;
		  }
	 public  static int InsertPatient(MedPlusBean medplus){
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("insert into tbl_patientdetails(pa_name,pa_age,pa_gender,pa_district,pa_disease) values(?,?,?,?,?)");
			  
			  pst.setString(1,medplus.getUname());
			  pst.setLong  (2,medplus.getAge());
			  pst.setString(3,medplus.getGender());
			  pst.setString(4,medplus.getDistrict());
			  pst.setString(5,medplus.getDisease());
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static ArrayList<MedPlusBean> patientView() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> eb=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_patientdetails");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setUname(rs.getString(2));
	        	medplus.setAge(rs.getInt(3));
	        	medplus.setGender(rs.getString(4));
	        	medplus.setDistrict(rs.getString(5));
	        	medplus.setDisease(rs.getString(6));
	        	eb.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return eb;
	    }
	 public static int insertprescription(MedPlusBean medplus){
		 try{
		 con=getDbConnection();
		  pst=con.prepareStatement("insert into tbl_prescription(p_username,p_medicinename,p_dosage,p_duration) values(?,?,?,?)");
		  
		  pst.setString(1,medplus.getUsername());
		  pst.setString(2,medplus.getMedicinename());
		  pst.setString(3,medplus.getDosage());
		  pst.setInt(4,medplus.getDuration());
		  pst.executeUpdate();
		  flag=1;
	  }
	 catch(Exception e){
		  e.printStackTrace();
	  }
	  return flag;
 
		 
	 }
	 public static ArrayList<MedPlusBean> bookingView() throws SQLException{
		 ArrayList<MedPlusBean>ls=new ArrayList<MedPlusBean>();
		 try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_booking");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt("b_id"));
	        	medplus.setUsername(rs.getString("b_name"));
	        	medplus.setDate(rs.getString("b_date"));
	        	
	        	ls.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return ls;
	    }
	 public static int updatebooking(MedPlusBean medplus)throws SQLException{
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_booking set b_status=? where b_id=?");
			  pst.setInt(2, medplus.getId());
			  pst.setString(1,medplus.getStatus());
			  pst.executeUpdate();
			  flag=1;
		  }
		  catch(SQLException sql){
			  sql.printStackTrace();
		  }
		  return flag;
		  
	  }
	 public static ArrayList<MedPlusBean> stockView() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> st=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_stockdetails");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setName(rs.getString(2));
	        	medplus.setQuantity(rs.getInt(3));
	        	medplus.setPrice(rs.getString(4));
	        	st.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return st;
	    }
	 public static String dateGenerate(MedPlusBean medplus){
			
			String date=null;
			String val=null;
			try{
				date= new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
				if(date.length()>2){
					val=date.substring(4,6);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return val;
			
			
			
		}
		
	public static String userGenerate(MedPlusBean medplus){
			
		String uname=medplus.getUname();
			String firstTwouname=null;
			try{
				
				if(uname.length()>1){
					firstTwouname=uname.substring(0,2);
				
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return firstTwouname;
			
			
			
		}
	public static String keyGenerate(MedPlusBean medplus) throws SQLException{
		
		String key="#";
		String first=dateGenerate(medplus);
		String second=userGenerate(medplus);
		key=first.concat(key);
		 key=key.concat(second);
		
		 
		 return key;
	}
	public static int keyInsert(MedPlusBean medplus) throws SQLException{
		try{
		con=getDbConnection();
		
		 pst=con.prepareStatement("insert into tbl_prescription(p_username,p_medicinename,p_dosage,p_duration,p_secretkey) values(?,?,?,?,?)");
		  
		  pst.setString(1,medplus.getUname());
		  pst.setString(2,medplus.getMedicinename());
		  pst.setString(3,medplus.getDosage());
		  pst.setInt(4,medplus.getDuration());
		  pst.setString(5,medplus.getKey());
		  pst.executeUpdate();
		  flag=1;
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
		
	}
	 public static ArrayList<MedPlusBean> giveMedicine(MedPlusBean medplus) throws SQLException{
	    	
	    	ArrayList<MedPlusBean> md=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	            
	            String storekey=medplus.getKey();
	            System.out.println(storekey);
	           
	        pst=con.prepareStatement("select * from TBL_PRESCRIPTION where p_secretkey='"+storekey+"'");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	
	        	medplus.setId(rs.getInt(1));
	        	medplus.setName(rs.getString(2));
	        	medplus.setMedicinename(rs.getString(3));
	        	medplus.setDosage(rs.getString(4));
	        	medplus.setDuration(rs.getInt(5));
	        	md.add(medplus);
	        }
	        
	    
	}catch(Exception e){
	        e.printStackTrace();
	    }
	    return md;
	    
	 }
	 public static ArrayList<MedPlusBean> remainder(int id) throws SQLException{
	    	
	    	ArrayList<MedPlusBean> re=new ArrayList<MedPlusBean>();
	    	
	try{
		
	            
	            con=getDbConnection();
	          
	            
	        pst=con.prepareStatement("select *from tbl_medicine where reg_id=?");
	        pst.setInt(1,id);
	        
	        rs=pst.executeQuery();
	       
	      
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setMedicinename(rs.getString(2));
	        	medplus.setTime(rs.getString(3));
	        	re.add(medplus);
	        	
	        }
	
	        
	    
	}catch(Exception e){
	        e.printStackTrace();
	    }
	    return re;
	    
	 }
	 public static int updateStockDAO(MedPlusBean medplus){
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_stockdetails set st_quantity=?,st_price=? where st_id=?");
			  
			  pst.setInt(1,medplus.getQuantity());
			  pst.setString(2,medplus.getPrice());
			  pst.setInt(3,medplus.getId());
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public  static int deleteStockDAO(MedPlusBean medplus){
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("delete from tbl_stockdetails  where st_id=?");
			  pst.setInt(1,medplus.getId());
			 
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static ArrayList<MedPlusBean> userView() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> uv=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_medrole");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setUname(rs.getString(2));
	        	medplus.setPassword(rs.getString(3));
	        	medplus.setRole(rs.getString(4));
	        	uv.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return uv;
	    }
	 public static int updateuser(MedPlusBean medplus){
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_medrole set med_password=?,med_role=? where med_id=?");
			  
			  pst.setString(1,medplus.getPassword());
			  pst.setString(2,medplus.getRole());
			  pst.setInt(3,medplus.getId());
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public  static int deleteuser(MedPlusBean medplus){
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("delete from tbl_medrole  where med_id=?");
			  pst.setInt(1,medplus.getId());
			 
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static ArrayList<MedPlusBean> nearStore() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> ns=new ArrayList<MedPlusBean>();
	    	
	try{
	            
	            con=getDbConnection();
	           	           
	        pst=con.prepareStatement("select * from tbl_storeloc");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	
	        	medplus.setId(rs.getInt(1));
	        	medplus.setUname(rs.getString(2));
	        	medplus.setPlace(rs.getString(5));
	        	ns.add(medplus);
	        }
	        
	    
	}catch(Exception e){
	        e.printStackTrace();
	    }
	    return ns;
	    
	 }
	 public static ArrayList<MedPlusBean> remainder1() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> uv=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_medicine");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setUname(rs.getString(2));
	        	medplus.setPassword(rs.getString(3));
	        	medplus.setRole(rs.getString(4));
	        	uv.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return uv;
	    }
	 
	 
	 
	 public static ArrayList<MedPlusBean> userMedView(int id) throws SQLException{
	    	
	    	ArrayList<MedPlusBean> uv=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_medicine where reg_id="+id+"");
	       rs=pst.executeQuery();
	      
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setMedicinename(rs.getString(2));
	        	medplus.setQuantity(rs.getInt(6));
	        	uv.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return uv;
	    }
	 public static int getQuantity(String medname){
		 MedPlusBean medplus=new MedPlusBean();
		 try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select m_newquantity from tbl_medicine where m_medname='"+medname+"'");
	       rs=pst.executeQuery();
	      
	        while(rs.next()){
	        	System.out.print("new quantity is"+rs.getInt("m_newquantity"));
	        	newQuantity=rs.getInt("m_newquantity");
	        	//int oldQuantity=rs.getInt("m_quantity ");	
	        	medplus.setQuantity(newQuantity);
	        	//medplus.setOldquantity(oldQuantity);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return newQuantity;
	    }
	 
	 
	 public static int updateQuantity(int quantity,String medname){
		 System.out.print("med name for"+" "+medname);
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_medicine set m_newquantity=? where m_medname=?");
			  
			  
			  pst.setInt(1,quantity);
			  pst.setString(2,medname);
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static double percentagemed(int newquantity,String medname){
		 int oldquantity=0;
		 try{
			 System.out.println("test"+" "+newquantity);
			 con=getDbConnection();
			 pst=con.prepareStatement("select m_quantity from tbl_medicine where m_medname='"+medname+"'");
			 rs=pst.executeQuery();
			 while(rs.next()){
				 oldquantity=rs.getInt(1);
				 
			 }
			 double perc=(double)newquantity/(double)oldquantity;
			 percentage=perc*100;
			 System.out.println("percentage"+" "+percentage);
			 
		 }
		 catch(Exception e){
			  e.printStackTrace();
		  }
		 
		 return percentage;		 
	 }
	 
	 
	 public static int updateuserMed(int id,int quantity)throws SQLException{
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_medicine set m_quantity=?,m_newquantity=? where m_id=?");
			  
			  pst.setInt(1,quantity);
			  pst.setInt(2,quantity);
			  pst.setInt(3,id);
			  flag=pst.executeUpdate();
			  
			 
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  System.out.print("flag ethraya"+" "+flag);
		  return flag;
	  }
	 public  static int deleteusermed(MedPlusBean medplus){
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("delete from tbl_medicine  where m_id=?");
			  pst.setInt(1,medplus.getId());
			 
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static ArrayList<MedPlusBean> medStoreView() throws SQLException{
	    	
	    	ArrayList<MedPlusBean> uv=new ArrayList<MedPlusBean>();
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select * from tbl_storeloc");
	       rs=pst.executeQuery();
	      
	        while(rs.next()){
	        	MedPlusBean medplus=new MedPlusBean();
	        	medplus.setId(rs.getInt(1));
	        	medplus.setStorename(rs.getString(2));
	        	medplus.setLongittude(rs.getDouble(3));
	        	medplus.setLattitude(rs.getDouble(4));
	        	medplus.setPlace(rs.getString(5));
	        	uv.add(medplus);
	        }
	        
	    } catch(Exception e){
	        e.printStackTrace();
	    }
	    return uv;
	    }
	 public  static int deletemedstore(MedPlusBean medplus){
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("delete from tbl_storeloc  where st_id=?");
			  pst.setInt(1,medplus.getId());
			 
			  pst.executeUpdate();
			  flag=1;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return flag;
	  }
	 public static int updateMedstore(MedPlusBean medplus)throws SQLException{
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("update tbl_storeloc set st_uname=?,st_longitude=?,st_lattitude=?,st_place=? where st_id=?");
			  
			  pst.setString(1,medplus.getName());
			  pst.setDouble(2, medplus.getLongittude());
			  pst.setDouble(3, medplus.getLattitude());
			 pst.setString(4, medplus.getPlace());
			 pst.setInt(5, medplus.getId());
			  flag=pst.executeUpdate();
			 
			 
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		 
		  return flag;
	  }
	 
		 
	 }
	 

	
	 

		
	
	 
	   



	